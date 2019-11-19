package edu.austral.starship.base.model.container.factory;

import edu.austral.starship.base.control.CollisionSpaceship;
import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;
import edu.austral.starship.base.model.PlayerModel;
import edu.austral.starship.base.model.SpaceshipModel;
import edu.austral.starship.base.model.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;


public class SpaceshipFactory extends Factory{

    public SpaceshipFactory(CollisionObjectContainer collisionables, ObjectModelContainer objects, DrawableContainer drawables) {
        super(collisionables, objects, drawables);
    }

    public SpaceshipModel createSpaceship(PlayerModel player, Vector2 initialPosition, PImage image, float width, float height) {

        String id = UUID.randomUUID().toString();

        SpaceshipModel object = new SpaceshipModel(id, initialPosition, player, 100, 100, width, height);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        Drawable drawable = new Sprite(image, element, width, height);

        drawables.addDrawable(drawable, id);

        //ShapedObject collisionable = new ShapedObject(); //TODO

        // Should this be done here or in every iteration?
        //Vector2 position = object.getPosition().substract(Vector2.vector(width/2, height/2));

        Shape rectangle = new Rectangle2D.Float(object.getPosition().getX() - width/2, object.getPosition().getY() - height/2, width, height); // The shape could be more sophisticated

        CollisionSpaceship collisionable = new CollisionSpaceship(object, rectangle, width, height);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
