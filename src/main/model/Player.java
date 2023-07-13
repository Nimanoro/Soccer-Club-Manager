package model;

public class Player {
    private int star;
    private Manager m;

    public Player() {
        star = 1;

    }


    public void setStar(int star) {
        this.star = star;
    }

    public int getStar() {
        return star;
    }


    public void improvePlayer() {
        this.star++;
        m.subCoin(100);
    }

}
