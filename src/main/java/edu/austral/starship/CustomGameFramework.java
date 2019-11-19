package edu.austral.starship;

import edu.austral.starship.base.control.CollisionEngine;
import edu.austral.starship.base.control.CollisionObject;
import edu.austral.starship.base.model.container.DrawableContainer;
import edu.austral.starship.base.model.container.ObjectModelContainer;
import edu.austral.starship.base.model.container.CollisionObjectContainer;
import edu.austral.starship.base.model.container.factory.AsteroidFactory;
import edu.austral.starship.base.model.container.factory.Destroyer;
import edu.austral.starship.base.model.container.factory.ProjectileFactory;
import edu.austral.starship.base.model.container.factory.SpaceshipFactory;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.model.*;
import edu.austral.starship.base.control.input.*;
import edu.austral.starship.base.model.vector.Vector2;
import edu.austral.starship.base.view.*;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.Set;
import java.util.UUID;

public class CustomGameFramework implements GameFramework {
    private InputInterpreter input;

    private AsteroidSpawner asteroidSpawner;

    private CollisionEngine<CollisionObject> engine;

    private DrawableContainer drawables = new DrawableContainer();

    private CollisionObjectContainer collisionables = new CollisionObjectContainer();

    private ObjectModelContainer objects = new ObjectModelContainer();

    private BoundingBox box = new BoundingBox(562, 1000);

    private Destroyer destroyer;

//    private List<SpaceshipModel> spaceships = new ArrayList<>();
    private SpaceshipModel spaceship;

    private PImage background;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(1000, 562);
        background = imageLoader.load("background.jpg");
        background.resize(1000, 562);

        destroyer = new Destroyer(drawables, collisionables, objects);

        engine = new CollisionEngine<>();

        SpaceshipFactory spaceshipFactory = new SpaceshipFactory(collisionables, objects, drawables);

        PImage asteroidImage = imageLoader.load("asteroid.png");

        PImage projectileImage = imageLoader.load("projectile.png");

        AsteroidFactory asteroidFactory = new AsteroidFactory(collisionables, objects, drawables, asteroidImage);

        asteroidSpawner = new AsteroidSpawner(asteroidFactory, 20, 80, 2, 50, Vector2.vector(1000, 562));

        input = new InputInterpreter();

        PImage spaceship1Image = imageLoader.load("spaceship.png");
        PlayerModel player = new PlayerModel();
        spaceship = spaceshipFactory.createSpaceship(player, Vector2.vector(30, 30), spaceship1Image, 50, 85); //75 125

        ProjectileFactory projectileFactory = new ProjectileFactory(collisionables, objects, drawables, projectileImage);

        WeaponModel weaponModel = new SmallWeaponModel(projectileFactory, spaceship, 10, 150,5,10, 20);

        spaceship.setWeaponModel(weaponModel);


        Action moveUp = new Move(spaceship, Vector2.vector(0, -0.05f));
        Action moveDown = new Move(spaceship, Vector2.vector(0, 0.05f));
        Action rotateRight = new Rotate(spaceship, 0.1f);
        Action rotateLeft = new Rotate(spaceship, -0.1f);
        Action shoot = new Shoot(spaceship);

        Key keyUp = new Key(moveUp, 38);
        Key keyDown = new Key(moveDown, 40);
        Key keyRight = new Key(rotateRight, 39);
        Key keyLeft = new Key(rotateLeft,37);
        Key keyShoot = new Key(shoot,32);

        input.addKey(keyUp);
        input.addKey(keyDown);
        input.addKey(keyRight);
        input.addKey(keyLeft);
        input.addKey(keyShoot);
        String id = UUID.randomUUID().toString();
        PlaceableObject placeableObject = new PlaceableObject(spaceship);
        drawables.addDrawable(new HealthBar(placeableObject, Vector2.vector(0, 0), spaceship), id);

    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        graphics.image(background, 500, 281, 1000, 562);

        for (Drawable drawable : drawables.getDrawables()) {
            drawable.draw(graphics);
        }

        for (ObjectModel object : objects.getObjects()) {
            box.checkBounds(object);
            if (object.isDestroyed()) {
                destroyer.destroy(object.getId());
            } else {
                object.update();
            }
        }

        for (CollisionObject collisionable : collisionables.getObjects()) {
            collisionable.update();
        }

        engine.checkCollisions(collisionables.getObjects());

        for (Integer keyCode : keySet) {
            input.interpret(keyCode);
        }

        asteroidSpawner.update();
        asteroidSpawner.create();

        if (spaceship.isDestroyed()) {
            drawables = new DrawableContainer();
            collisionables = new CollisionObjectContainer();
            objects = new ObjectModelContainer();
                createScoreLabel(spaceship.getPlayer(), Vector2.vector(500, 250 + 20));
            Placeable spot = new UIElement(Vector2.vector(500, 281));
            drawables.addDrawable(new Label(spot, "Game Over", Vector2.vector(0, 0)), "Game");

        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
        private void createScoreLabel(PlayerModel player, Vector2 position) {
            Valuable score = new Score(player);

            Placeable spot = new UIElement(position);

            Drawable label = new Label(spot, "Points: ", "", score, Vector2.vector(0,0));

            String id = UUID.randomUUID().toString();

            drawables.addDrawable(label, id);
        }
}
