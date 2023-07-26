package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


// This class is made to make the user's team. It contains three fields
// Player, point and manager.
public class Team extends Predefinedteams {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Integer point;
    private String name;
    private Manager manager;

    public Team(Manager m1) {
        super("Dream Team");
        this.manager = m1;
        this.point = 0;
        this.name = "Dream Team";
    }


    public void addPlayer(Player p1) {
        this.players.add(p1);
    }


    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /*
     * EFFECTS:Get the overall of the team based on the power of the players.
     */
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

    public Boolean makePlayer(String name, Manager manager) {
        if (manager.getCoin() >= 100) {
            Player p1;

            p1 = new Player(manager, 1);
            manager.subCoin(100);
            p1.setName(name);
            addPlayer(p1);
            return true;
        } else {
            return false;
        }

    }

    public Manager getManager() {
        return this.manager;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("point", super.getPoint());
        json.put("manager", manager.toJson());
        json.put("players", playersToJson());
        json.put("name",name);
        return json;
    }

    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Player p: players) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }
}
