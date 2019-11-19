package edu.austral.starship.base.model;

import edu.austral.starship.base.model.vector.Vector2;

public abstract class ObjectModel {

    String id;

    Vector2 position;

    Vector2 velocity;

    float width;

    float height;

    float orientation;

    boolean destroyed;

    public abstract void update();

    void updatePosition() {
        this.position = position.add(velocity);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getVelocity()  {
        return this.velocity;
    }

    public float getOrientation() {
        return this.orientation;
    }

    public String getId() {
        return id;
    }

    public abstract void leftPerimeter();

    public void stop(Vector2 vector) {
        this.velocity = velocity.add(vector);
    }

    public void destroy() {
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }
}
