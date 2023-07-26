package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Random;


// This class is made to make the game and produce its result. It contains four fields
// Team, Predefined team, goal1, goal2.
public class Game implements Writable {
    private Predefinedteams t1;
    private Team t2;
    private int goal1;
    private int goal2;


    public Game(Predefinedteams t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /*

     * MODIFIES: this
     * EFFECTS:Generate the result of the game based on the strengh of the
     * competing teams.
     */
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


    /*
    * MODIFIES: Team, Predefined Team
    * EFFECTS:Update the points of the competing teams based on the result of the game
    *
            */
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

    /*
     * MODIFIES: Manager
     * EFFECTS:Update the coins of the manager based on the result of the game
     * 100 for win, 25 for loss, 50 for tie
     *
     */
    public void updateCoins() {
        if (this.goal1 > this.goal2) {
            t2.getManager().addCoin(25);
        } else if (this.goal1 < this.goal2) {
            t2.getManager().addCoin(100);
        } else {
            t2.getManager().addCoin(50);
        }

    }

    public Team getT2() {
        return this.t2;
    }

    public Predefinedteams getT1() {
        return this.t1;
    }

    public int getGoal1() {
        return goal1;
    }

    public int getGoal2() {
        return goal2;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("PreTeam", t1);
        json.put("team",t2);
        return json;
    }
}
