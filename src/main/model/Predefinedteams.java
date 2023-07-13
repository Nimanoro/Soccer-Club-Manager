package model;

public class Predefinedteams {
    private int overall;
    private int points;

    public Predefinedteams() {

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
}
