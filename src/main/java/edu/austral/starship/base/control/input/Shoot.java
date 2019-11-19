package edu.austral.starship.base.control.input;

import edu.austral.starship.base.model.SpaceshipModel;

public class Shoot implements Action{

    private SpaceshipModel spaceship;

    public Shoot(SpaceshipModel spaceship) {
        this.spaceship = spaceship;
    }

    public void execute() {
        spaceship.shoot();
    }
}
