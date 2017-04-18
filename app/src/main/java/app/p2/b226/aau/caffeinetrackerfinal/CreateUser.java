package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void Enter(View view){


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
