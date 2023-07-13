package model;

import java.util.ArrayList;

public class Fixture {
    ArrayList<Game> games = new ArrayList<Game>();
    private Team team;
    private ArrayList<Predefinedteams> preTeams = new ArrayList<Predefinedteams>();

    public Fixture(Team t) {
        this.team = t;

    }

    public void addPreDTeams(Predefinedteams t1) {
        this.preTeams.add(t1);
    }

    public ArrayList<Predefinedteams> getPreTeams() {
        return this.preTeams;
    }

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
