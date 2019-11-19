package edu.austral.starship.base.model;

import edu.austral.starship.base.model.vector.Vector2;

public class AsteroidModel extends ObjectModel implements Damageable, Scoreable {
    private int health;

    private int maxHealth;

    private int pointValue;

    private float size;

    public AsteroidModel(String id, Vector2 position, Vector2 velocity, float size) {
        this.maxHealth = (int) size/5;
        this.health = maxHealth;
        this.pointValue = health;
        this.size = size;
        super.position = position;
        super.velocity = velocity;
        super.id = id;
    }

    public void update() {
        updatePosition();
        if (health <= 0) destroy();
    }

    public void damage(int health) {
        this.health -= health;
    }

    public void leftPerimeter() {
        this.destroy();
    }

    public float getSize() {
        return size;
    }

    public int returnPoints() {
        return this.pointValue;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
