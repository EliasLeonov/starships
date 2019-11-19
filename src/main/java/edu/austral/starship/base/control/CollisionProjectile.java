package edu.austral.starship.base.control;

import edu.austral.starship.base.model.AsteroidModel;
import edu.austral.starship.base.model.ProjectileModel;
import edu.austral.starship.base.model.SpaceshipModel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CollisionProjectile extends CollisionObject {

    private ProjectileModel projectile;

    public CollisionProjectile(ProjectileModel projectile, Shape shape, float width, float height) {
        this.projectile = projectile;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitProjectile(this.projectile);
    }

    @Override
    public void update() {
        super.shape = new Rectangle2D.Float(projectile.getPosition().getX() - width/2, projectile.getPosition().getY() - height/2, width, height);
    }

    @Override
    public void visitAsteroid(AsteroidModel asteroid) {
        if (projectile.getDamage() >= asteroid.getHealth()) {
            projectile.resolveCollision(asteroid);
        }
        this.projectile.destroy();
    }

    @Override
    public void visitProjectile(ProjectileModel projectile) {

    }

    @Override
    public void visitSpaceship(SpaceshipModel spaceship) {
        if (projectile.getDamage() >= spaceship.getHealth()) {
            projectile.resolveCollision(spaceship);
        }
        this.projectile.destroy();
    }
}
