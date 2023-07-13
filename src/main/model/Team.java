package model;

import java.util.ArrayList;
import java.util.Set;

public class Team {
    private ArrayList<Player> players = new ArrayList<Player>();

    public Team() {

    }

    public void addPlayer(Player p1) {
        this.players.add(p1);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public double overall() {
        int i = 0;
        double result = 0;
        while (players.size() > i) {
            Player p = players.get(i);
            result += p.getStar();
            i++;
        }
        return result / players.size();
    }

}
