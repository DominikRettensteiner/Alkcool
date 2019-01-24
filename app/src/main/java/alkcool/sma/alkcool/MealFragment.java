package alkcool.sma.alkcool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MealFragment extends Fragment {

    private Button addMealButton;
    private EditText mealName;
    private EditText mealPercent;
    private ListView mealList;

    private MealList AllMeals = new MealList();

    public MealFragment() {
    }

    public static MealFragment newInstance() {
        return new MealFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meal, container, false);

        addMealButton = v.findViewById(R.id.addMealButton);
        mealName = (EditText) v.findViewById(R.id.mealName);
        mealPercent = (EditText) v.findViewById(R.id.mealPercent);
        mealList = (ListView) v.findViewById(R.id.mealList);

        UpdateList();

        addMealButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        mealList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i = new Intent(getActivity(), AddMealActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("index", position);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        return v;
    }

    public void buttonClicked(View v) {
        String name = mealName.getText().toString();
        double points = 0;
        if(mealPercent.getText().toString().trim().length() != 0){
            points = Double.parseDouble(mealPercent.getText().toString()) * (-1);
        }
        mealName.setText("");
        mealPercent.setText("");
        if((!name.equals("")) && (points < 0)
                && (!AllMeals.contains(name, points)) && (name.trim().length() > 0)){
            Meal meal = new Meal(name, points);
            AllMeals.list.add(meal);
            UpdateList();
        }
    }

    private void UpdateList(){
        AllMeals.sort();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.my_textview, AllMeals.getStringList());
        mealList.setAdapter(adapter);
    }
}
