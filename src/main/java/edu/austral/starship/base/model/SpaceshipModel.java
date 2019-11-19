package edu.austral.starship.base.model;

import edu.austral.starship.base.control.input.Movable;
import edu.austral.starship.base.control.input.Rotatable;
import edu.austral.starship.base.model.vector.Vector2;

public class SpaceshipModel extends ObjectModel implements Movable, Rotatable, Damageable, Scoreable {

    private int maxHealth;
    private int health;

    private PlayerModel player;

    private int pointValue;

    private WeaponModel weaponModel;

    private float height;

    private float width;

    private int switchCounter;

    public SpaceshipModel(String id, Vector2 position, PlayerModel player, int pointValue, int health, float width, float height) {
        super.id = id;
        super.position = position;
        super.velocity = Vector2.vector(0, 0);
        this.player = player;
        this.maxHealth = health;
        this.health = health;
        this.pointValue = pointValue;
        super.destroyed = false;
        this.width = width;
        this.height = height;
        this.switchCounter = 11;
    }

    public void update() {
        updatePosition();
        weaponModel.update();
        if (health <= 0) destroy();
        switchCounter++;
    }

    public void accelerate(Vector2 vector) {
        this.velocity = this.velocity.add(vector.rotate(orientation));
    }

    public void rotate(float factor) {
        this.orientation += factor;
    }

    public void leftPerimeter() {
    }

    public PlayerModel getPlayer() {
        return this.player;
    }


    public void damage(int health) {
        this.health -= health;
    }

    public int returnPoints() {
        return this.pointValue;
    }

    public void shoot() {
        weaponModel.shoot();
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setWeaponModel(WeaponModel weaponModel) {
        this.weaponModel = weaponModel;
    }
}
