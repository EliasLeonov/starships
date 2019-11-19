package edu.austral.starship.base.model.container;

import edu.austral.starship.base.control.CollisionObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionObjectContainer {

    private Map<String, CollisionObject> collisions;

    public CollisionObjectContainer() {
        collisions = new HashMap<>();
    }

    public void addObject(CollisionObject object, String key) {
        collisions.put(key, object);
    }

    public void removeObject(String key) {
        collisions.remove(key);
    }

    public List<CollisionObject> getObjects() {
        return new ArrayList<>(collisions.values());
    }
}
