package model;

import java.util.ArrayList;
import java.util.Collections;

public class League {
    ArrayList<Predefinedteams> teams = new ArrayList<Predefinedteams>();
    ArrayList<Predefinedteams> standing = new ArrayList<Predefinedteams>();


    public void setTeams(ArrayList<Predefinedteams> l1) {
        this.teams = l1;
    }

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
}
