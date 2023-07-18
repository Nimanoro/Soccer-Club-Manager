package model;

// This class is made to make the manager customizable. It contains two fields
// the name of the manager and it's coin inventory.
public class Manager {
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
}
