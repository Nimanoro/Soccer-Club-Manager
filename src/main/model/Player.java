package model;

import org.json.JSONObject;
import persistence.Writable;

// This class is made to make a player. It contains three fields
// Star, A manager and the player name.
public class Player implements Writable {
    private int star;
    private Manager m1;
    private String name;
    private String imageSrc;

    public Player(Manager m,int star) {
        this.star = star;
        this.m1 = m;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setImageSrc(String src) {
        this.imageSrc = src;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public int getStar() {
        return star;
    }

    public Manager getM1() {
        return m1;
    }

    /*
     * MODIFIES: this, Manager
     * EFFECTS:Change the stars of the player if possible (stars < 5)
     * return true if the transaction happened and false if it did'nt
     *
     */
    public Boolean improvePlayer() {
        if (this.star < 5) {
            this.star++;
            m1.subCoin(10);
            EventLog.getInstance().logEvent(new Event("Updated player: "
                    + this.getName() + ": " + this.getStar()));
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("star", star);
        json.put("Manager", m1.toJson());
        json.put("name", name);
        json.put("img", imageSrc);
        return json;
    }
}
