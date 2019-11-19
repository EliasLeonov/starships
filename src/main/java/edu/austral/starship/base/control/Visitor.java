package edu.austral.starship.base.control;

import edu.austral.starship.base.model.AsteroidModel;
import edu.austral.starship.base.model.ProjectileModel;
import edu.austral.starship.base.model.SpaceshipModel;

public interface Visitor {

    public void visitAsteroid(AsteroidModel asteroid);

    public void visitSpaceship(SpaceshipModel spaceship);

    public void visitProjectile(ProjectileModel projectile);
}
