package edu.austral.starship.base.model;

import edu.austral.starship.base.model.vector.Vector2;

public class BoundingBox {

    private Vector2 box;

    public BoundingBox(float height, float width) {
        this.box = Vector2.vector(width, height);
    }

    public void checkBounds(ObjectModel object) {
        Vector2 position = object.getPosition();
        Vector2 velocity = object.getVelocity();
        Vector2 stop = Vector2.vector(0, 0);

        if (position.getX() < 0 && velocity.getX() < 0) {
            stop = stop.add(Vector2.vector(-velocity.getX(), 0));
        } else if (position.getX() > this.box.getX() && velocity.getX() > 0) {
            stop = stop.add(Vector2.vector(-velocity.getX(), 0));
        }
        if (position.getY() < 0 && velocity.getY() < 0) {
            stop = stop.add(Vector2.vector(0, -velocity.getY()));
        } else if (position.getY() > this.box.getY() && velocity.getY() > 0) {
            stop = stop.add(Vector2.vector(0, -velocity.getY()));
        }

        if (stop.getX() != 0 || stop.getY() != 0) {
            object.stop(stop);
            object.leftPerimeter();
        }
    }
}
