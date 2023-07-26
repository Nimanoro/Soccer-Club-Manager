package model;

import org.json.JSONObject;
import persistence.Writable;

// This class is made to make the predefined teams. It contains three fields
// Overall, points and the team name.
public class Predefinedteams implements Writable {
    private int overall;
    private int points;
    private String name;

    public Predefinedteams(String n) {
        this.name = n;

    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public double getOverall() {
        return overall;
    }

    public int getPoint() {
        return this.points;
    }

    /*Requires: positive Int
     * MODIFIES: this
     * EFFECTS:update the points of the Predefined team by the given amount
     *
     */
    public void updatePoints(int amount) {
        this.points = this.points + amount;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("overall", overall);
        json.put("point", points);
        json.put("name", name);
        return json;
    }
}
