package edu.austral.starship.base.model.container.factory;

import edu.austral.starship.base.control.CollisionAsteroid;
import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;
import edu.austral.starship.base.model.AsteroidModel;
import edu.austral.starship.base.model.vector.Vector2;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;

public class AsteroidFactory extends Factory {

    private PImage image;

    public AsteroidFactory(CollisionObjectContainer collisionables, ObjectModelContainer objects, DrawableContainer drawables, PImage image) {
        super(collisionables, objects, drawables);
        this.image = image;
    }

    public AsteroidModel createAsteroid(Vector2 initialPosition, Vector2 initialVelocity, float size) {

        String id = UUID.randomUUID().toString();

        AsteroidModel object = new AsteroidModel(id, initialPosition, initialVelocity, size);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        Sprite drawable = new Sprite(image, element, size, size);

        drawables.addDrawable(drawable, id);

        Shape rectangle = new Rectangle2D.Float(object.getPosition().getX() - size/2, object.getPosition().getY() - size/2, size, size); // The shape could be more sophisticated

        CollisionAsteroid collisionable = new CollisionAsteroid(object, rectangle, size, size);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
