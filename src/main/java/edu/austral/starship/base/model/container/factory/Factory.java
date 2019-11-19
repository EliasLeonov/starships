package edu.austral.starship.base.model.container.factory;

import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;

public abstract class Factory {

    CollisionObjectContainer collisionables;

    ObjectModelContainer objects;

    DrawableContainer drawables;

    public Factory(CollisionObjectContainer collisionables, ObjectModelContainer objects, DrawableContainer drawables) {
        this.collisionables = collisionables;
        this.objects = objects;
        this.drawables = drawables;
    }
}
