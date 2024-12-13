package com.example.demo.actor;

/**
 * {@code FighterPlane} is an abstract class that extends {@link ActiveActorDestructible} and represents a fighter plane in the game.
 * This class includes the plane's health, ability to take damage, and functionality for firing projectiles. It serves as a base
 * class for various types of fighter planes in the game.
 */
public abstract class FighterPlane extends ActiveActorDestructible {

	private int health;

	/**
	 * Constructs a new {@code FighterPlane} with the specified image, height, position, and health.
	 *
	 * @param imageName The name of the image file for the fighter plane (should be in the {@code /com/example/demo/images/} directory).
	 * @param imageHeight The height to which the image should be resized.
	 * @param initialXPos The initial horizontal position (X coordinate) of the fighter plane.
	 * @param initialYPos The initial vertical position (Y coordinate) of the fighter plane.
	 * @param health The initial health of the fighter plane.
	 */
	public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		this.health = health;
	}

	/**
	 * Abstract method to be implemented by subclasses to define the behavior when the fighter plane fires a projectile.
	 *
	 * @return An instance of {@link ActiveActorDestructible} representing the fired projectile.
	 */
	public abstract ActiveActorDestructible fireProjectile();

	/**
	 * Handles the damage taken by the fighter plane. Decreases the plane's health and destroys the plane if health reaches zero.
	 */
	@Override
	public void takeDamage() {
		health--;
		if (healthAtZero()) {
			this.destroy();
		}
	}

	/**
	 * Returns the X position of a projectile relative to the fighter plane's current position, adjusted by the given offset.
	 *
	 * @param xPositionOffset The horizontal offset to be added to the fighter plane's current X position.
	 * @return The X position of the projectile.
	 */
	protected double getProjectileXPosition(double xPositionOffset) {
		return getLayoutX() + getTranslateX() + xPositionOffset;
	}

	/**
	 * Returns the Y position of a projectile relative to the fighter plane's current position, adjusted by the given offset.
	 *
	 * @param yPositionOffset The vertical offset to be added to the fighter plane's current Y position.
	 * @return The Y position of the projectile.
	 */
	protected double getProjectileYPosition(double yPositionOffset) {
		return getLayoutY() + getTranslateY() + yPositionOffset;
	}

	/**
	 * Checks whether the fighter plane's health has reached zero.
	 *
	 * @return {@code true} if the fighter plane's health is zero, otherwise {@code false}.
	 */
	private boolean healthAtZero() {
		return health == 0;
	}

	/**
	 * Returns the current health of the fighter plane.
	 *
	 * @return The current health of the fighter plane.
	 */
	public int getHealth() {
		return health;
	}
}
