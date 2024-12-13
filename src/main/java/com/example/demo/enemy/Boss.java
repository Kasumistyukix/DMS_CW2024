package com.example.demo.enemy;

import com.example.demo.actor.ActiveActorDestructible;
import com.example.demo.actor.FighterPlane;
import com.example.demo.projectile.BossProjectile;
import com.example.demo.showImage.ShieldImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Boss class represents the boss enemy in the game.
 * It extends from the FighterPlane class and includes features like movement patterns, firing projectiles, and shield activation.
 */
public class Boss extends FighterPlane {

	/**
	 * The file name for the boss plane image.
	 */
	private static final String IMAGE_NAME = "bossplane.png";

	/**
	 * The initial X position of the boss.
	 */
	private static final double INITIAL_X_POSITION = 1000.0;

	/**
	 * The initial Y position of the boss.
	 */
	private static final double INITIAL_Y_POSITION = 400;

	/**
	 * The vertical offset for the projectile's position relative to the boss plane.
	 */
	private static final double PROJECTILE_Y_POSITION_OFFSET = 75.0;

	/**
	 * The probability that the boss will fire a projectile in any given frame.
	 */
	private static final double BOSS_FIRE_RATE = .04;

	/**
	 * The probability that the boss will activate its shield in any given frame.
	 */
	private static final double BOSS_SHIELD_PROBABILITY = 0.03;

	/**
	 * The height of the boss plane image.
	 */
	private static final int IMAGE_HEIGHT = 300;

	/**
	 * The vertical movement speed of the boss.
	 */
	private static final int VERTICAL_VELOCITY = 8;

	/**
	 * The initial health of the boss.
	 */
	private static int bossHealth = 50;

	/**
	 * The number of movement steps per cycle.
	 */
	private static final int MOVE_FREQUENCY_PER_CYCLE = 5;

	/**
	 * A constant value for no vertical movement.
	 */
	private static final int ZERO = 0;

	/**
	 * The maximum number of frames the boss will perform the same move before changing its direction.
	 */
	private static final int MAX_FRAMES_WITH_SAME_MOVE = 10;

	/**
	 * The upper Y-bound for the boss's movement.
	 */
	private static final int Y_POSITION_UPPER_BOUND = -100;

	/**
	 * The lower Y-bound for the boss's movement.
	 */
	private static final int Y_POSITION_LOWER_BOUND = 475;

	/**
	 * The maximum number of frames the shield remains active before deactivating.
	 */
	private static final int MAX_FRAMES_WITH_SHIELD = 50;

	/**
	 * List representing the boss's movement pattern.
	 */
	private final List<Integer> movePattern;

	/**
	 * Boolean flag to determine if the boss is shielded.
	 */
	private boolean isShielded;

	/**
	 * The number of consecutive moves the boss has made in the same direction.
	 */
	private int consecutiveMovesInSameDirection;

	/**
	 * The current index of the boss's move pattern.
	 */
	private int indexOfCurrentMove;

	/**
	 * The number of frames the boss's shield has been activated.
	 */
	private int framesWithShieldActivated;

	/**
	 * The shield image for the boss.
	 */
	private final ShieldImage shieldImage;

	/**
	 * Constructor for the Boss class. Initializes the boss with its image, health, and movement pattern.
	 */
	public Boss() {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, bossHealth);
		movePattern = new ArrayList<>();
		consecutiveMovesInSameDirection = 0;
		indexOfCurrentMove = 0;
		framesWithShieldActivated = 0;
		isShielded = false;
		initializeMovePattern();
		this.shieldImage = new ShieldImage(INITIAL_X_POSITION, INITIAL_Y_POSITION);
	}

	/**
	 * Updates the position of the boss.
	 * Moves the boss vertically based on the current movement pattern and adjusts shield image position.
	 */
	@Override
	public void updatePosition() {
		double initialTranslateY = getTranslateY();
		moveVertically(getNextMove());
		double currentPosition = getLayoutY() + getTranslateY();
		shieldImage.setLayoutY(currentPosition);
		if (currentPosition < Y_POSITION_UPPER_BOUND || currentPosition > Y_POSITION_LOWER_BOUND) {
			setTranslateY(initialTranslateY);
		}
	}

	/**
	 * Updates the state of the boss.
	 * Calls methods to update position and shield state.
	 */
	@Override
	public void updateActor() {
		updatePosition();
		updateShield();
	}

	/**
	 * Fires a projectile from the boss.
	 * A new projectile is fired if the boss decides to fire in the current frame.
	 *
	 * @return A new BossProjectile if fired, or null if no projectile is fired.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return bossFiresInCurrentFrame() ? new BossProjectile(getProjectileInitialPosition()) : null;
	}

	/**
	 * Handles the boss taking damage.
	 * The boss will not take damage if it is shielded.
	 */
	@Override
	public void takeDamage() {
		if (!isShielded) {
			super.takeDamage();
		}
	}

	/**
	 * Initializes the movement pattern of the boss.
	 * The pattern includes vertical movements with random directions.
	 */
	private void initializeMovePattern() {
		for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
			movePattern.add(VERTICAL_VELOCITY);
			movePattern.add(-VERTICAL_VELOCITY);
			movePattern.add(ZERO);
		}
		Collections.shuffle(movePattern);
	}

	/**
	 * Updates the shield state of the boss.
	 * The shield can be activated or deactivated based on certain conditions.
	 */
	private void updateShield() {
		if (isShielded) {
			framesWithShieldActivated++;
			shieldImage.showShield();
		} else if (shieldShouldBeActivated()) {
			activateShield();
		}
		if (shieldExhausted()) {
			deactivateShield();
			shieldImage.hideShield();
		}
	}

	/**
	 * Determines the next vertical move in the boss's movement pattern.
	 *
	 * @return The next vertical move value.
	 */
	private int getNextMove() {
		int currentMove = movePattern.get(indexOfCurrentMove);
		consecutiveMovesInSameDirection++;
		if (consecutiveMovesInSameDirection == MAX_FRAMES_WITH_SAME_MOVE) {
			Collections.shuffle(movePattern);
			consecutiveMovesInSameDirection = 0;
			indexOfCurrentMove++;
		}
		if (indexOfCurrentMove == movePattern.size()) {
			indexOfCurrentMove = 0;
		}
		return currentMove;
	}

	/**
	 * Determines if the boss fires in the current frame based on the fire rate.
	 *
	 * @return true if the boss fires, false otherwise.
	 */
	private boolean bossFiresInCurrentFrame() {
		return Math.random() < BOSS_FIRE_RATE;
	}

	/**
	 * Gets the initial position for firing a projectile based on the boss's current Y position.
	 *
	 * @return The initial Y position for the projectile.
	 */
	private double getProjectileInitialPosition() {
		return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
	}

	/**
	 * Determines if the boss should activate its shield based on the probability.
	 *
	 * @return true if the shield should be activated, false otherwise.
	 */
	private boolean shieldShouldBeActivated() {
		return Math.random() < BOSS_SHIELD_PROBABILITY;
	}

	/**
	 * Determines if the boss's shield has been active for the maximum duration.
	 *
	 * @return true if the shield is exhausted, false otherwise.
	 */
	private boolean shieldExhausted() {
		return framesWithShieldActivated == MAX_FRAMES_WITH_SHIELD;
	}

	/**
	 * Activates the boss's shield.
	 */
	private void activateShield() {
		isShielded = true;
	}

	/**
	 * Deactivates the boss's shield.
	 */
	private void deactivateShield() {
		isShielded = false;
		framesWithShieldActivated = 0;
	}

	/**
	 * Gets the shield image of the boss.
	 *
	 * @return The ShieldImage instance associated with the boss.
	 */
	public ShieldImage shieldImage() {
		return shieldImage;
	}

	/**
	 * Sets the boss's health to the specified value.
	 *
	 * @param newHealth The new health value for the boss.
	 */
	public void setBossHP(int newHealth) {
		bossHealth = newHealth;
	}
}
