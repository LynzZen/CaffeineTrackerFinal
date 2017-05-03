package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Context;
import android.icu.text.TimeZoneNames;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SettingsFragment extends Fragment {

    EditText nameEdit;
    RadioButton smokingYes;
    RadioButton smokingNo;
    EditText defaultCupEdit;
    EditText goalEdit;
    Button updateButton;


    int defaultCup;
    String name;
    boolean smoke;
    int goal;


    //Default Constructor
    public SettingsFragment(){

    }

    public SettingsFragment(String name, boolean smoke,int goal, int defaultCup){
        this.name = name;
        this.smoke = smoke;
        this.goal = goal;
        this.defaultCup = defaultCup;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameEdit = (EditText) view.findViewById(R.id.name_edit);
        smokingYes = (RadioButton) view.findViewById(R.id.smoking_yes);
        smokingNo = (RadioButton) view.findViewById(R.id.smoking_no);
        updateButton = (Button) view.findViewById(R.id.update_button);
        goalEdit = (EditText) view.findViewById(R.id.goal_edit);
        defaultCupEdit = (EditText) view.findViewById(R.id.cup_size_edit);

        goalEdit.setText(Integer.toString(goal));
        nameEdit.setText((CharSequence) name);
        defaultCupEdit.setText(Integer.toString(defaultCup));
        if (smoke){
            smokingYes.setChecked(true);
            smokingNo.setChecked(false);
        } else {
            smokingYes.setChecked(false);
            smokingNo.setChecked(true);
        }

        smokingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoke = true;
                smokingNo.setChecked(false);
            }
        });
        smokingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoke = false;
                smokingYes.setChecked(false);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = nameEdit.getText().toString();
                int newDefaultCup = Integer.parseInt(defaultCupEdit.getText().toString());
                int newGoal = Integer.parseInt(goalEdit.getText().toString());

                ((MainActivity)getActivity()).updateUser(newName,smoke,newGoal,newDefaultCup);
                Toast.makeText(getActivity(), "User Updated!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
