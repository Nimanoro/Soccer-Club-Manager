package model;

import java.util.ArrayList;

public class Team extends Predefinedteams {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Integer point;
    Manager manager;

    public Team(Manager m1) {
        super("Dream Team");
        this.manager = m1;
        this.point = 0;
    }


    public void addPlayer(Player p1) {
        this.players.add(p1);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public double getOverall() {
        int i = 0;
        double result = 0;
        while (players.size() > i) {
            Player p = players.get(i);
            result += p.getStar();
            i++;
        }
        return result / players.size();
    }

    public Manager getManager() {
        return this.manager;
    }

}
