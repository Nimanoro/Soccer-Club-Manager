package model;

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

    public void improvePlayer() {
        this.star++;
        m1.subCoin(100);
    }

    public String getName() {
        return this.name;
    }

}
