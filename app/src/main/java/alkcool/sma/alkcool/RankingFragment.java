package alkcool.sma.alkcool;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RankingFragment extends Fragment{

    private TableLayout rankingTable;
    private PlayerList AllPlayers = new PlayerList();
    private boolean initialized = false;

    public RankingFragment() {
    }

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //UpdateList(getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);

        rankingTable = (TableLayout) v.findViewById(R.id.rankingTable);

        UpdateList(v);

        return v;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            UpdateList(getView());
        }
    }

    public void UpdateList(View v){
        if(initialized) rankingTable.removeAllViews();
        initialized = true;
        int i = 1;
        AllPlayers.sort();
        for(final Player p : AllPlayers.list){
            if(i<=10) {
                TableRow tr = new TableRow(getActivity());

                TextView place = new TextView(getActivity());
                String st = Integer.toString(i) + ".";
                place.setTextSize(30);
                place.setText(st);
                place.setWidth(160);
                place.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
                place.setTextColor(Color.rgb(0, 0, 0));

                TextView name = new TextView(getActivity());
                name.setText(p.playerName);
                name.setTextSize(30);
                name.setWidth(360);
                name.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
                name.setTextColor(Color.rgb(0, 0, 0));

                /*name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for(AlkAmount a : p.alkAmountList) {
                            Toast.makeText(getActivity(), a.alk.alkName + " " + a.amount.AmountName + " " + a.anzahl, Toast.LENGTH_LONG).show();
                        }
                    }
                });*/

                TextView score = new TextView(getActivity());
                String s = Integer.toString(p.points);
                score.setTextSize(30);
                score.setWidth(200);
                score.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
                score.setTextColor(Color.rgb(0, 0, 0));
                score.setText(s);

                if (i == 1) {
                    place.setBackgroundColor(Color.rgb(255, 215, 0));
                    name.setBackgroundColor(Color.rgb(255, 215, 0));
                    score.setBackgroundColor(Color.rgb(255, 215, 0));
                } else if (i == 2) {
                    place.setBackgroundColor(Color.rgb(192, 192, 192));
                    name.setBackgroundColor(Color.rgb(192, 192, 192));
                    score.setBackgroundColor(Color.rgb(192, 192, 192));
                } else if (i == 3) {
                    place.setBackgroundColor(Color.rgb(205, 127, 50));
                    name.setBackgroundColor(Color.rgb(205, 127, 50));
                    score.setBackgroundColor(Color.rgb(205, 127, 50));
                }

                tr.addView(place);
                tr.addView(name);
                tr.addView(score);

                rankingTable.addView(tr, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }
            i++;
        }
    }
}
