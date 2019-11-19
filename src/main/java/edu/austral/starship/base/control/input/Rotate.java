package edu.austral.starship.base.control.input;

public class Rotate implements Action{

    private Rotatable rotatable;

    private float factor;

    public Rotate(Rotatable rotatable, float factor) {
        this.rotatable = rotatable;
        this.factor = factor;
    }

    public void execute() {
        rotatable.rotate(factor);
    }
}
