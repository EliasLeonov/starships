package edu.austral.starship.base.control.input;

public class Key {

    private Action action;

    private int keyCode;

    public Key(Action action, int keyCode) {
        this.action = action;
        this.keyCode = keyCode;
    }

    public void execute() {
        action.execute();
    }

    public boolean implemented(int keyCode) {
        return keyCode == this.keyCode; //check if this actually works.
    }
}
