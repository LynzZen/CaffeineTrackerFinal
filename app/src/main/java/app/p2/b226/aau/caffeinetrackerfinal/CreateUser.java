package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class CreateUser extends AppCompatActivity {
    User theUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void Enter(View view){

        createUser("hej",10,true);

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
