package app.p2.b226.aau.caffeinetrackerfinal;

import java.io.Serializable;

public class User implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoalInMg() {
        return goalInMg;
    }

    public void setGoalInMg(int goalInMg) {
        this.goalInMg = goalInMg;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean smoker) {
        isSmoker = smoker;
    }

    int goalInMg;
    boolean isSmoker;

    public User(String name, int goalInMg, boolean isSmoker) {
        this.name = name;
        this.goalInMg = goalInMg;
        this.isSmoker = isSmoker;
    }
}


