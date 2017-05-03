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
    User theUser;

    public MainFragment(){

    }
    public MainFragment(User theUser){
        this.theUser = theUser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //theTextView = (TextView) view.findViewById(R.id.display_caffeine);
        //theTextView.setText(theUser.getCaffeineInSystem()+"");
        theButton = (Button) view.findViewById(R.id.add_cup);
        theButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theUser.setCaffeineInSystem(theUser.getCaffeineInSystem()+theUser.getDefaultCup());
                int goalInCups = Math.round(theUser.getGoalInMg()/theUser.getDefaultCup());
                theTextView.setText("The Goal is: " + goalInCups + " cups, and the amount of caffeine in your system is: "
                       + theUser.getCaffeineInSystem()+ ", which is equlivant to: " +
                        Math.round(theUser.getCaffeineInSystem()/theUser.getDefaultCup()) + " cups");
            }
        });



    }


}
