package com.example.demo.projectile;

import com.example.demo.actor.ActiveActorDestructible;

/**
 * The {@code Projectile} class represents a projectile in the game, such as bullets or missiles.
 * It is an abstract class that extends {@code ActiveActorDestructible}, enabling projectiles
 * to have destructible properties and dynamic positioning.
 */
public abstract class Projectile extends ActiveActorDestructible {

	/**
	 * Constructs a new {@code Projectile} instance with the specified properties.
	 *
	 * @param imageName    the name of the image file representing the projectile.
	 * @param imageHeight  the height of the projectile's image in pixels.
	 * @param initialXPos  the initial x-coordinate of the projectile.
	 * @param initialYPos  the initial y-coordinate of the projectile.
	 */
	public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * When a projectile takes damage, it is immediately destroyed.
	 */
	@Override
	public void takeDamage() {
		this.destroy();
	}

	/**
	 * Updates the projectile's position on the screen.
	 * This method must be implemented by subclasses to define specific movement behavior.
	 */
	@Override
	public abstract void updatePosition();

}

