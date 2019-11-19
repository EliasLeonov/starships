package edu.austral.starship.base.control;

import edu.austral.starship.base.model.AsteroidModel;
import edu.austral.starship.base.model.ProjectileModel;
import edu.austral.starship.base.model.SpaceshipModel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CollisionAsteroid extends CollisionObject {

    private AsteroidModel asteroid;

    public CollisionAsteroid(AsteroidModel asteroid, Shape shape, float width, float height) {
        this.asteroid = asteroid;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    public void accept(Visitor visitor) {
        visitor.visitAsteroid(this.asteroid);
    }

    public void update() {
        super.shape = new Rectangle2D.Float(asteroid.getPosition().getX() - width/2, asteroid.getPosition().getY() - height/2, width, height);
    }
    @Override
    public void visitProjectile(ProjectileModel projectile) {
        asteroid.damage(projectile.getDamage());
    }
    @Override
    public void visitAsteroid(AsteroidModel asteroid) {}
    @Override
    public void visitSpaceship(SpaceshipModel spaceship) {
        asteroid.destroy();
    }
}
