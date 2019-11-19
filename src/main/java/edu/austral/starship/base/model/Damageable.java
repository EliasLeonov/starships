package edu.austral.starship.base.model;

public interface Damageable {

    void damage(int health);

    int getHealth();

    int getMaxHealth();
}
