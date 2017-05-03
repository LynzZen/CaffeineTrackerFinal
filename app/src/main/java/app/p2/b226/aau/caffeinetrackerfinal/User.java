package app.p2.b226.aau.caffeinetrackerfinal;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    int goal;
    boolean isSmoker;
    int defaultCup;

    int caffeineInSystem;

    public User(String name, int goalInMg, boolean isSmoker, int defaultCup) {
        this.name = name;
        this.goal = goalInMg;
        this.isSmoker = isSmoker;
        this.defaultCup = defaultCup;
        caffeineInSystem = 0;

    }

    public int getCaffeineInSystem() {
        return caffeineInSystem;
    }

    public void setCaffeineInSystem(int caffeineInSystem) {
        this.caffeineInSystem = caffeineInSystem;
    }

    public int getDefaultCup() {
        return defaultCup;
    }

    public void setDefaultCup(int defaultCup) {
        this.defaultCup = defaultCup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoalInMg() {
        return goal;
    }

    public void setGoalInMg(int goalInMg) {
        this.goal = goalInMg;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean smoker) {
        isSmoker = smoker;
    }


}


