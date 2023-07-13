package model;

import java.util.Random;
import java.util.StringJoiner;

import static java.lang.Math.random;

public class Game {
    private Predefinedteams t1;
    private Team t2;
    private int goal1;
    private int goal2;


    public Game(Predefinedteams t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public String generateResult() {
        int difference = (int) (t1.getOverall() - t2.getOverall());
        Random rand = new Random();
        int max1 = 5 + difference;
        int min1 = 0;
        this.goal1 = rand.nextInt(max1);
        int max2 = 5 - difference;
        this.goal2 = rand.nextInt(max2);
        return Integer.toString(goal1) + "-" + Integer.toString(goal2);

    }

    public void setGoal1(int g1) {
        this.goal1 = g1;
    }

    public void setGoal2(int g2) {
        this.goal2 = g2;
    }

    public void updatePoints() {
        if (this.goal1 > this.goal2) {
            t1.updatePoints(3);
        } else if (this.goal1 < this.goal2) {
            t2.updatePoints(3);
        } else {
            t1.updatePoints(1);
            t2.updatePoints(1);
        }
    }

    public void updateCoins() {
        if (this.goal1 > this.goal2) {
            t2.getManager().addCoin(25);
        } else if (this.goal1 < this.goal2) {
            t2.getManager().addCoin(100);
        } else {
            t2.getManager().addCoin(50);
        }

    }
}
