package alkcool.sma.alkcool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AddDrinkFragment extends Fragment{

    private TextView AlkHeadLine;

    private AlkList AllAlks;

    public AddDrinkFragment() {
    }

    public static AddDrinkFragment newInstance(int index) {
        AddDrinkFragment f = new AddDrinkFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adddrink, container, false);

        Bundle args = getArguments();
        int index = args.getInt("index");

        AlkHeadLine = (TextView) v.findViewById(R.id.AlkHeadLine);
        AlkHeadLine.setText(AllAlks.getString(index));

        return v;
    }
}
