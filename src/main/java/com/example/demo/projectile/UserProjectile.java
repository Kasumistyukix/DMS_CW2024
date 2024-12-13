package com.example.demo.projectile;

/**
 * The {@code UserProjectile} class represents a projectile fired by the player's plane.
 * It extends the {@code Projectile} class and defines the unique properties and behaviors
 * of projectiles fired by the user.
 */
public class UserProjectile extends Projectile {

	/**
	 * The image name for the user's projectile.
	 * This string specifies the file name of the projectile image.
	 */
	private static final String IMAGE_NAME = "userfire.png";

	/**
	 * The height of the user's projectile image.
	 * Defines the vertical size of the projectile image in pixels.
	 */
	private static final int IMAGE_HEIGHT = 125;

	/**
	 * The horizontal velocity of the user's projectile.
	 * Determines how fast the projectile moves horizontally (to the right).
	 */
	private static final int HORIZONTAL_VELOCITY = 15;


	/**
	 * Constructs a new {@code UserProjectile} instance with specified initial x- and y-coordinates.
	 *
	 * @param initialXPos the initial x-coordinate of the projectile.
	 * @param initialYPos the initial y-coordinate of the projectile.
	 */
	public UserProjectile(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
	}

	/**
	 * Updates the position of the projectile by moving it horizontally to the right.
	 * The movement is determined by the {@code HORIZONTAL_VELOCITY}.
	 */
	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	/**
	 * Updates the state of the projectile.
	 * For {@code UserProjectile}, this simply updates its position.
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}
}
