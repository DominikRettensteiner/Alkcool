package alkcool.sma.alkcool;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class AlkFragment extends Fragment {

    private Button addAlkButton;
    private EditText alkName;
    private EditText alkPercent;
    private ListView alkList;

    private AlkList AllAlks = new AlkList();

    public AlkFragment() {
    }

    public static AlkFragment newInstance() {
        return new AlkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alk, container, false);

        addAlkButton = v.findViewById(R.id.addAlkButton);
        alkName = (EditText) v.findViewById(R.id.alkName);
        alkPercent = (EditText) v.findViewById(R.id.alkPercent);
        alkList = (ListView) v.findViewById(R.id.alkList);

        UpdateList();

        addAlkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        alkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            }
        });

        return v;
    }

    public void buttonClicked(View v) {
        String name = alkName.getText().toString();
        double percent = 0;
        if(alkPercent.getText().toString().trim().length() != 0){
            percent = Double.parseDouble(alkPercent.getText().toString());
        }
        alkName.setText("");
        alkPercent.setText("");
        if((!name.equals("")) && (percent > 0)
                && (!AllAlks.contains(name, percent)) && (name.trim().length() > 0)){
            Alk alk = new Alk(name, percent);
            AllAlks.list.add(alk);
            UpdateList();
        }
    }

    private void UpdateList(){
        AllAlks.sort();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, AllAlks.getStringList());
        alkList.setAdapter(adapter);
    }
}
