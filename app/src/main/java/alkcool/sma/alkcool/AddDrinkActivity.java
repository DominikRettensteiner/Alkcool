package alkcool.sma.alkcool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddDrinkActivity extends AppCompatActivity {
    private TextView AlkHeadline;
    private Spinner playerDropDown;
    private Spinner amountDropDown;
    private Button SubmitButton;

    private Alk alk;
    private AlkList AllAlks = new AlkList();
    private PlayerList AllPlayers = new PlayerList();
    private AmountList AllAmounts = new AmountList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("index");

        AlkHeadline = this.findViewById(R.id.AlkHeadLine);
        playerDropDown = this.findViewById(R.id.playerDropDown);
        amountDropDown = this.findViewById(R.id.amountDropDown);
        SubmitButton = this.findViewById(R.id.submit);

        alk = AllAlks.list.get(index);
        AlkHeadline.setText(AllAlks.getString(index));

        ArrayList<String> playerList = AllPlayers.getNameList();
        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(this,
                R.layout.my_textview, playerList);
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerDropDown.setAdapter(playerAdapter);

        ArrayList<String> amountList = AllAmounts.getStringList();
        ArrayAdapter<String> amountAdapter = new ArrayAdapter<String>(this,
                R.layout.my_textview, amountList);
        amountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amountDropDown.setAdapter(amountAdapter);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
    }

    private void buttonClicked(View v){
        String playerName = playerDropDown.getSelectedItem().toString();
        String amountName = amountDropDown.getSelectedItem().toString();
        int points = AllPlayers.addPoints(playerName, amountName, alk);
        Toast.makeText(this, playerName + ": +"+points+" Punkte", Toast.LENGTH_LONG).show();
    }
}
