package model;

import java.util.ArrayList;


// This class is made to make the game schedule for the user's team. It contains three fields
// Team, A list of predefined teams and a list of game.
public class Fixture {
    ArrayList<Game> games = new ArrayList<Game>();
    private Team team;
    private ArrayList<Predefinedteams> preTeams = new ArrayList<Predefinedteams>();

     //REQUIRES: accountName has a non-zero length
     //EFFECTS: Construct a fixture
    public Fixture(Team t) {
        this.team = t;

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
}
