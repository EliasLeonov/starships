package edu.austral.starship.base.control;

import edu.austral.starship.base.model.AsteroidModel;
import edu.austral.starship.base.model.ProjectileModel;
import edu.austral.starship.base.model.SpaceshipModel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class CollisionSpaceship extends CollisionObject {

    private SpaceshipModel spaceship;

    public CollisionSpaceship(SpaceshipModel spaceship, Shape shape, float width, float height) {
        this.spaceship = spaceship;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    public void accept(Visitor visitor) {
        visitor.visitSpaceship(this.spaceship);
    }

    public void update() {
        Shape newShape = new Rectangle2D.Float(0 - width/2, 0 - height/2, width, height);
        AffineTransform tx = new AffineTransform();
        tx.translate(spaceship.getPosition().getX(), spaceship.getPosition().getY());
        tx.rotate(spaceship.getOrientation());
        super.shape = tx.createTransformedShape(newShape);
    }

    public void visitAsteroid(AsteroidModel asteroid) {
        spaceship.damage((int) asteroid.getSize()/5);
    }

    public void visitProjectile(ProjectileModel projectile) {
        spaceship.damage(projectile.getDamage());
    }

    public void visitSpaceship(SpaceshipModel spaceship) {
    }
}
