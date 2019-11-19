package edu.austral.starship.base.model;

public abstract class ProjectileModel extends ObjectModel {

    int damage;

    float lifespan;

    float lifespanCounter;

    public void leftPerimeter() {
        this.destroy();
    }

    public void resolveCollision(Scoreable scoreable) {
        awardPoints(scoreable);
    }

    public abstract void awardPoints(Scoreable scoreable);

    public int getDamage() {
        return damage;
    }
}
