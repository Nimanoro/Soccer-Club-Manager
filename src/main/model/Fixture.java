package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;


// This class is made to make the game schedule for the user's team. It contains three fields
// Team, A list of predefined teams and a list of game.
public class Fixture implements Writable {
    ArrayList<Game> games = new ArrayList<Game>();
    private Team team;
    private ArrayList<Predefinedteams> preTeams = new ArrayList<Predefinedteams>();
    private int week;

     //REQUIRES: accountName has a non-zero length
     //EFFECTS: Construct a fixture
    public Fixture(Team t) {
        this.team = t;
        week = 0;

    }

    public void addAWeek() {
        this.week += 1;

    }

    public void setWeek(Integer amount) {
        this.week = amount;
    }

    public int getWeek() {
        return this.week;
    }

    public void addPreDTeams(Predefinedteams t1) {
        this.preTeams.add(t1);
    }

    public ArrayList<Predefinedteams> getPreTeams() {
        return this.preTeams;
    }

    //Modifies: this
    //EFFECTS: make the schedule of games for team VS each Predefined teams
    public void setGames() {
        for (int i = 0; i < preTeams.size(); i++) {
            Game g1 = new Game(this.preTeams.get(i), team);
            this.games.add(g1);

        }
    }

    public ArrayList<Game> getGames() {
        return this.games;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("week", week);
        json.put("team", team);
        json.put("predTeams", preTeamsTOJson());
        json.put("games", gamesToJson());
        return json;
    }

    public JSONArray preTeamsTOJson() {
        JSONArray jsonArray = new JSONArray();
        for (Predefinedteams preteam: preTeams) {
            jsonArray.put(preteam.toJson());
        }
        return jsonArray;
    }

    public JSONArray gamesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Game game: games) {
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put(game.getT1().toJson());
            jsonArray1.put(game.getT2().toJson());
            jsonArray.put(jsonArray1);
        }
        return jsonArray;
    }

}
