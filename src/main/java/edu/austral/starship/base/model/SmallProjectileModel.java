package edu.austral.starship.base.model;

import edu.austral.starship.base.model.vector.Vector2;

public class SmallProjectileModel extends ProjectileModel {

    private PlayerModel owner;

    public SmallProjectileModel(String id, PlayerModel owner, Vector2 position, Vector2 velocity, int damage, float lifespan) {
        super.damage = damage;
        super.lifespan = lifespan;
        super.id = id;
        this.owner = owner;
        super.position = position;
        super.velocity = velocity;
        super.destroyed = false;
        super.lifespanCounter = 0;
    }

    public void update() {
        updatePosition();
        lifespanCounter++;
        if (lifespanCounter > lifespan) {
            this.destroy();
        }
    }

    public void awardPoints(Scoreable scoreable) {
        owner.addPoints(scoreable.returnPoints());
    }
}
