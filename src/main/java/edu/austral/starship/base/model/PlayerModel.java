package edu.austral.starship.base.model;

public class PlayerModel {

    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return this.points;
    }
}
