package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class CreateUser extends AppCompatActivity {
    User theUser;

    EditText nameEdit;
    Switch smokeSwitch;
    EditText goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        nameEdit = (EditText) findViewById(R.id.EditName);
        goal = (EditText) findViewById(R.id.goalEdit);
        smokeSwitch = (Switch) findViewById(R.id.SmokingSwitch);

    }



    public void Enter(View view){

        String name = nameEdit.getText().toString();
        int goalinMg = Integer.parseInt(goal.getText().toString());
        boolean isSmoking = smokeSwitch.isChecked();

        createUser(name,goalinMg,isSmoking);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Auser", theUser);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void createUser(String name, int goal, boolean isSmoking){
        theUser = new User(name,goal,isSmoking);
        Toast.makeText(this, theUser.name, Toast.LENGTH_LONG).show();
    }
}
