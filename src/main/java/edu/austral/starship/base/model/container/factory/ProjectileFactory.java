package edu.austral.starship.base.model.container.factory;

import edu.austral.starship.base.control.CollisionProjectile;
import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;
import edu.austral.starship.base.model.PlayerModel;
import edu.austral.starship.base.model.SmallProjectileModel;
import edu.austral.starship.base.model.ProjectileModel;
import edu.austral.starship.base.model.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;

public class ProjectileFactory extends Factory {

    private PImage image;

    public ProjectileFactory(CollisionObjectContainer collisionables, ObjectModelContainer objects, DrawableContainer drawables, PImage image) {
        super(collisionables, objects, drawables);
        this.image = image;
    }

    public ProjectileModel createProjectile(PlayerModel player, Vector2 initialPosition, Vector2 velocity, int damage, float lifespan, float projectileSize) {

        String id = UUID.randomUUID().toString();

        int size = (int) projectileSize;

        //check lifespan value
        ProjectileModel object = new SmallProjectileModel(id, player, initialPosition, velocity, damage, lifespan);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        Drawable drawable = new Sprite(image, element, size, size);

        drawables.addDrawable(drawable, id);

        //Shape ellipse = new Ellipse2D.Float(object.getPosition().getX() - size/2, object.getPosition().getY() - size/2, size, size);

        //ShapedProjectile collisionable = new ShapedProjectile(object, ellipse, size, size);

        Shape rectangle = new Rectangle2D.Float(object.getPosition().getX() - size/2, object.getPosition().getY() - size/2, size, size);

        CollisionProjectile collisionable = new CollisionProjectile(object, rectangle, size, size);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
