package edu.austral.starship.base.model.container;

import edu.austral.starship.base.model.ObjectModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectModelContainer {

    private Map<String, ObjectModel> objects;

    public ObjectModelContainer() {
        objects = new HashMap<>();
    }

    public void addObject(ObjectModel object, String key) {
        objects.put(key, object);
    }

    public void removeObject(String key) {
        objects.remove(key);
    }

    public List<ObjectModel> getObjects() {
        return new ArrayList<>(objects.values());
    }
}
