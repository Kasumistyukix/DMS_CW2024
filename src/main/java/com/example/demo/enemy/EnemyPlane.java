package com.example.demo.enemy;

import com.example.demo.actor.ActiveActorDestructible;
import com.example.demo.actor.FighterPlane;
import com.example.demo.projectile.EnemyProjectile;
/**
 * EnemyPlane represents an enemy fighter plane in the game.
 * It extends from the FighterPlane class and provides functionality for movement, projectile firing, and updating its state.
 */
public class EnemyPlane extends FighterPlane {

	/**
	 * The file name of the image used for the enemy plane.
	 */
	private static final String IMAGE_NAME = "enemyplane.png";

	/**
	 * The height of the enemy plane image.
	 */
	private static final int IMAGE_HEIGHT = 50;

	/**
	 * The horizontal velocity (movement speed) of the enemy plane.
	 * Negative value moves the plane to the left.
	 */
	private static final int HORIZONTAL_VELOCITY = -6;

	/**
	 * The horizontal offset for the position of the enemy projectile.
	 * Used to determine where the projectile is fired from relative to the plane.
	 */
	private static final double PROJECTILE_X_POSITION_OFFSET = -100.0;

	/**
	 * The vertical offset for the position of the enemy projectile.
	 * Used to determine where the projectile is fired from relative to the plane.
	 */
	private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;

	/**
	 * The initial health of the enemy plane.
	 */
	private static final int INITIAL_HEALTH = 1;

	/**
	 * The fire rate of the enemy plane, determining the likelihood of firing a projectile each time.
	 * A value between 0 and 1.
	 */
	private static final double FIRE_RATE = .01;

	/**
	 * Constructor for the EnemyPlane.
	 * Initializes the enemy plane with a specified initial X and Y position, and uses default image, size, and health values.
	 *
	 * @param initialXPos The initial X-coordinate position of the enemy plane.
	 * @param initialYPos The initial Y-coordinate position of the enemy plane.
	 */
	public EnemyPlane(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
	}

	/**
	 * Updates the position of the enemy plane.
	 * Moves the enemy plane horizontally based on the defined horizontal velocity.
	 */
	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	/**
	 * Fires a projectile from the enemy plane.
	 * If the random number generated is less than the fire rate, a new enemy projectile is created and returned.
	 *
	 * @return An instance of EnemyProjectile if the projectile is fired, or null if no projectile is fired.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		if (Math.random() < FIRE_RATE) {
			double projectileXPosition = getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET);
			double projectileYPosition = getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET);
			return new EnemyProjectile(projectileXPosition, projectileYPosition);
		}
		return null;
	}

	/**
	 * Updates the enemy plane's state.
	 * Calls the updatePosition method to move the plane.
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}
}
