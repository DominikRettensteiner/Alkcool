package alkcool.sma.alkcool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddMealActivity extends AppCompatActivity {
    private TextView MealHeadline;
    private Spinner playerDropDown;
    private Button SubmitButton;

    private Meal meal;
    private MealList AllMeals = new MealList();
    private PlayerList AllPlayers = new PlayerList();
    private AmountList AllAmounts = new AmountList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("index");

        MealHeadline = this.findViewById(R.id.MealHeadLine);
        playerDropDown = this.findViewById(R.id.playerDropDown);
        SubmitButton = this.findViewById(R.id.submit);

        meal = AllMeals.list.get(index);
        MealHeadline.setText(AllMeals.getString(index));

        ArrayList<String> playerList = AllPlayers.getNameList();
        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(this,
                R.layout.my_textview, playerList);
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerDropDown.setAdapter(playerAdapter);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
    }

    private void buttonClicked(View v){
        String playerName = playerDropDown.getSelectedItem().toString();
        int points = AllPlayers.removePoints(playerName, meal);
        Toast.makeText(this, playerName + ": "+points+" Punkte", Toast.LENGTH_LONG).show();
    }
}
