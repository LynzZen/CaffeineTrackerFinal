package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Context;
import android.icu.text.TimeZoneNames;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class SettingsFragment extends Fragment {

    Button saveButton;
    EditText nameField;
    Switch isSmokingField;
    EditText goalInMg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameField = (EditText) view.findViewById(R.id.NameType);
        isSmokingField = (Switch) view.findViewById(R.id.SmokingSwitch);
        goalInMg = (EditText) view.findViewById(R.id.GoalInMgField);
        saveButton = (Button) view.findViewById(R.id.Savebutton);
        saveButton.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener(){
        public void onClick(View v){
            String name = (String) nameField.getText().toString();
            boolean isSmoking = isSmokingField.isChecked();
            int goal = Integer.parseInt( goalInMg.getText().toString());
            ((MainActivity)getActivity()).createUser(name);

            Toast.makeText(getActivity(), name + " " + isSmoking + " " + goal + "mg", Toast.LENGTH_LONG).show();
        }

    };


}
