package model;

public class Predefinedteams {
    private int overall;
    private int points;
    private String name;

    public Predefinedteams(String n) {
        this.name = n;

    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public double getOverall() {
        return overall;
    }

    public int getPoint() {
        return this.points;
    }

    public void updatePoints(int amount) {
        this.points = this.points + amount;
    }

    public String getName() {
        return this.name;
    }
}
