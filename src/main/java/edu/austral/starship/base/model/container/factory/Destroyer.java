package edu.austral.starship.base.model.container.factory;


import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;


public class Destroyer {

    private DrawableContainer drawables;

    private CollisionObjectContainer collisionables;

    private ObjectModelContainer objects;

    public Destroyer(DrawableContainer drawables, CollisionObjectContainer collisionables, ObjectModelContainer objects) {
        this.drawables = drawables;
        this.collisionables = collisionables;
        this.objects = objects;
    }

    public void destroy(String id) {
        drawables.removeDrawable(id);
        collisionables.removeObject(id);
        objects.removeObject(id);
    }
}
