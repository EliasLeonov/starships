package edu.austral.starship.base.control;

import java.awt.*;

public interface Collisionable<T extends Collisionable<T>> {
    Shape getShape();

    void collisionWith(T collisionable);
}
