package model;

import org.json.JSONObject;
import persistence.Writable;

// This class is made to make the manager customizable. It contains two fields
// the name of the manager and it's coin inventory.
public class Manager implements Writable {
    private String name;
    private Integer coin;

    public Manager() {
        this.name = "player1";
        this.coin = 0;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {

        return this.name;
    }

    public Integer getCoin() {

        return this.coin;
    }

    /*Requires: positive Int
     * MODIFIES: this
     * EFFECTS:add to the number of coins of the manager
     *
     */
    public void addCoin(int amount) {

        this.coin = this.getCoin() + amount;
    }


    /*Requires: positive Int
     * MODIFIES: this
     * EFFECTS:subtract from the number of coins of the manager
     *
     */
    public void subCoin(int amount) {

        this.coin = this.getCoin() - amount;
    }

    public void setCoin(int amount) {
        this.coin = amount;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("manager name", name);
        json.put("coin", coin);
        return json;
    }
}
