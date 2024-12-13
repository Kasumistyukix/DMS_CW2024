package com.example.demo.projectile;

/**
 * The {@code BossProjectile} class represents a specialized projectile fired by a boss enemy.
 * It extends the {@code Projectile} class and provides unique behavior for boss projectiles,
 * including its size, velocity, and starting position.
 */
public class BossProjectile extends Projectile {

	/**
	 * The image name for the boss's projectile.
	 * This string specifies the file name of the boss projectile image.
	 */
	private static final String IMAGE_NAME = "fireball.png";

	/**
	 * The height of the boss's projectile image.
	 * Defines the vertical size of the boss's projectile image in pixels.
	 */
	private static final int IMAGE_HEIGHT = 75;

	/**
	 * The horizontal velocity of the boss's projectile.
	 * Determines how fast the projectile moves horizontally (to the left).
	 */
	private static final int HORIZONTAL_VELOCITY = -15;

	/**
	 * The initial X position where the boss's projectile will appear.
	 * Defines the horizontal starting point of the projectile in pixels.
	 */
	private static final int INITIAL_X_POSITION = 950;


	/**
	 * Constructs a new {@code BossProjectile} instance with a specified initial y-coordinate.
	 * The x-coordinate is set to {@code INITIAL_X_POSITION}.
	 *
	 * @param initialYPos the initial y-coordinate of the projectile.
	 */
	public BossProjectile(double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
	}

	/**
	 * Updates the position of the projectile by moving it horizontally to the left.
	 * The movement is determined by the {@code HORIZONTAL_VELOCITY}.
	 */
	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	/**
	 * Updates the actor's state. For {@code BossProjectile}, this simply updates its position.
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}
}

