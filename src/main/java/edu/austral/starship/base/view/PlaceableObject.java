package edu.austral.starship.base.view;

import edu.austral.starship.base.model.ObjectModel;
import edu.austral.starship.base.model.vector.Vector2;

public class PlaceableObject implements Placeable, Orientable{

    private ObjectModel object;

    public PlaceableObject(ObjectModel object) {
        this.object = object;
    }

    public Vector2 getPosition(){
        return object.getPosition();
    }

    public float getOrientation(){
        return object.getOrientation();
    }
}
