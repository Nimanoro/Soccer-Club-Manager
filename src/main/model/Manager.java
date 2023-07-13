package model;

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

    public void addCoin(int amount) {
        this.coin = this.getCoin() + amount;
    }

    public void subCoin(int amount) {
        this.coin = this.getCoin() - amount;
    }
}
