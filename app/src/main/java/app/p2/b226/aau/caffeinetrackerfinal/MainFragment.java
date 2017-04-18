package app.p2.b226.aau.caffeinetrackerfinal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainFragment extends Fragment {

    TextView theTextView;
    Button theButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        theTextView = (TextView) view.findViewById(R.id.Heine);
        theButton = (Button) view.findViewById(R.id.theButton);
        theButton.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String theName = ((MainActivity)getActivity()).TheUser.getName();
            int goal = ((MainActivity)getActivity()).TheUser.getGoalInMg();
            boolean isSmoking = ((MainActivity)getActivity()).TheUser.isSmoker();
            String tempTxt;
            if (isSmoking){
                tempTxt = "is smoking";
            } else {
                tempTxt = "is not smoking";
            }

            theTextView.setText("Name: " + theName + ". Goal: " + goal + ". " + tempTxt);
        }
    };
}
