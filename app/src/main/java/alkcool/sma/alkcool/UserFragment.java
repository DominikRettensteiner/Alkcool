package alkcool.sma.alkcool;

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

public class UserFragment extends Fragment{

    private Button addUser;
    private EditText playerName;
    private ListView playerList;

    private PlayerList AllPlayers = new PlayerList();

    public UserFragment() {
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        addUser = v.findViewById(R.id.addPlayerButton);
        playerName = (EditText) v.findViewById(R.id.playerName);
        playerList = (ListView) v.findViewById(R.id.playerList);

        UpdateList();

        addUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(AllPlayers.list.get(position).points == 0){
                    AllPlayers.list.remove(position);
                    UpdateList();
                }
            }
        });

        return v;
    }

    public void buttonClicked(View v) {
        String name = playerName.getText().toString();
        playerName.setText("");
        if((!name.equals("")) && (!AllPlayers.contains(name)) && (name.trim().length() > 0)){
            if(name.length() > 10){
                name = name.substring(0, 9);
            }
            Player player = new Player(name);
            AllPlayers.list.add(player);
            UpdateList();
        }
    }

    private void UpdateList(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.my_textview, AllPlayers.getNameList());
        playerList.setAdapter(adapter);
    }
}
