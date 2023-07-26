package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;

// This class is made to make the league standing. It holds all the team + Predefined teams as it field.
public class League implements Writable {
    ArrayList<Predefinedteams> teams = new ArrayList<Predefinedteams>();
    ArrayList<Predefinedteams> standing = new ArrayList<Predefinedteams>();


    public void setTeams(ArrayList<Predefinedteams> l1) {
        this.teams = l1;
    }


    public void addTeam(Predefinedteams team) {
        teams.add(team);
    }
    /*
     * MODIFIES: League
     * EFFECTS:Update the standing based on the competing teams point.
     *
     */
    public void sortTeams() {
        for (int i = 1; i < this.teams.size(); i++) {
            Predefinedteams key = this.teams.get(i);
            int j = i - 1;

            while (j >= 0 && this.teams.get(j).getPoint() > key.getPoint()) {
                this.teams.set(j + 1, this.teams.get(j));
                j = j - 1;
            }

            this.teams.set(j + 1, key);




        }
        Collections.reverse(teams);
    }

    public ArrayList<Predefinedteams> getTeams() {
        return teams;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("teams", teamsToJson());
        return json;
    }

    public JSONArray teamsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Predefinedteams t: teams) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }
}
