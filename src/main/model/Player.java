package model;

// This class is made to make a player. It contains three fields
// Star, A manager and the player name.
public class Player {
    private int star;
    private Manager m1;
    private String name;

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
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

}
