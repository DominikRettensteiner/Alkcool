package alkcool.sma.alkcool;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
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

import org.w3c.dom.Text;

public class RankingFragment extends Fragment {

    private TableLayout rankingTable;
    private PlayerList AllPlayers = new PlayerList();

    public RankingFragment() {
    }

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);

        rankingTable = (TableLayout) v.findViewById(R.id.rankingTable);

        int i = 1;
        AllPlayers.sort();
        for(Player p : AllPlayers.list){
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

        return v;
    }
}
