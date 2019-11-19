package edu.austral.starship.base.control.input;


import java.util.ArrayList;
import java.util.List;

public class InputInterpreter {

    private List<Key> keys;

    public InputInterpreter() {
        keys = new ArrayList<>();
    }

    public void addKey(Key key) {
        keys.add(key);
    }

    public void interpret(int keyCode) {
        for (Key savedKey : keys) {
            if (savedKey.implemented(keyCode)) {
                savedKey.execute();
            }
        }
    }
}
