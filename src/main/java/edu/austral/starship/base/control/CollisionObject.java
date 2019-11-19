package edu.austral.starship.base.control;

import java.awt.*;

public abstract class CollisionObject implements Collisionable<CollisionObject>, Visitor, Visitable {
    Shape shape;
    float width;
    float height;

    @Override
    public void collisionWith(CollisionObject object) {
        object.accept(this);
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    public abstract void update();
}
