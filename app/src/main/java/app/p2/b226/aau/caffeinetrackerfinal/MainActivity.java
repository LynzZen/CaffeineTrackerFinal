package app.p2.b226.aau.caffeinetrackerfinal;

import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User TheUser;
    String userName = "";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    if (TheUser != null) {
                        changingFragment(new MainFragment(TheUser));
                    }
                    return true;
                case R.id.navigation_dashboard:
                    changingFragment(new VisualizationFragment());
                    return true;

                case R.id.navigation_notifications:
                    changingFragment(new MainFragment());
                    return true;

                case R.id.navigation_other:
                    String name = TheUser.getName();
                    int goal = TheUser.getGoalInMg();
                    int defaultCup = TheUser.getDefaultCup();
                    boolean smoke = TheUser.isSmoker();
                    changingFragment(new SettingsFragment(name,smoke,goal,defaultCup));
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            TheUser = (User) bundle.getSerializable("Auser");
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changingFragment(new MainFragment(TheUser));

    }

    public void changingFragment(Fragment frag){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content, frag);
        ft.addToBackStack(null);
        ft.commit();
    }



    public void updateUser(String name, boolean isSmoking, int goal, int defaultCup){
        TheUser.setName(name);
        TheUser.setGoalInMg(goal);
        TheUser.setSmoker(isSmoking);
        TheUser.setDefaultCup(defaultCup);
    }

    public void updateVisualization(){
        MainVisualizationView.CaffeineIntaken += TheUser.getDefaultCup();
        MainVisualizationView.CaffeineGoal = TheUser.getGoalInMg();
    }


}




