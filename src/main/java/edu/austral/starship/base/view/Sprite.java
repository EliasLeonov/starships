package edu.austral.starship.base.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class Sprite implements Drawable{

    private PImage image;

    private PlaceableObject placeable;

    private float width;

    private float height;

    public Sprite(PImage image, PlaceableObject placeable, float width, float height) {
        this.image = image;
        this.placeable = placeable;
        this.width = width;
        this.height = height;
    }

    public void draw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(placeable.getPosition().getX(), placeable.getPosition().getY());
        graphics.rotate(placeable.getOrientation());
        graphics.image(image, 0, 0, width, height);
        graphics.popMatrix();
    }
}
