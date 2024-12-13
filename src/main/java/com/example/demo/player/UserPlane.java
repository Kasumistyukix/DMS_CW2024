package com.example.demo.player;

import com.example.demo.actor.ActiveActorDestructible;
import com.example.demo.actor.FighterPlane;
import com.example.demo.projectile.UserProjectile;
import com.example.demo.abilities.Ability;
import javafx.scene.image.Image;

/**
 * The {@code UserPlane} class represents the player's fighter plane in the game.
 * It extends the {@code FighterPlane} class and incorporates functionality such as
 * movement, firing projectiles, managing abilities, and handling invincibility.
 */
public class UserPlane extends FighterPlane {

	/**
	 * Default plane image for the user.
	 */
	private static final String IMAGE_NAME = "userplane.png";

	/**
	 * Image for the user plane when it is in an invincible state.
	 */
	private static final String IMAGE_NAME_INVINCIBLE = "userplane_Invincible.png";

	/**
	 * Path location for the images used in the game.
	 */
	private static final String IMAGE_LOCATION = "/com/example/demo/images/";

	/**
	 * The upper bound of the Y-axis for the plane's movement.
	 */
	private static final double Y_UPPER_BOUND = -40;

	/**
	 * The lower bound of the Y-axis for the plane's movement.
	 */
	private static final double Y_LOWER_BOUND = 600.0;

	/**
	 * The upper bound of the X-axis for the plane's movement.
	 */
	private static final double X_UPPER_BOUND = 1200;

	/**
	 * The lower bound of the X-axis for the plane's movement.
	 */
	private static final double X_LOWER_BOUND = 5.0;

	/**
	 * The initial X-axis position of the user plane when the game starts.
	 */
	private static final double INITIAL_X_POSITION = 5.0;

	/**
	 * The initial Y-axis position of the user plane when the game starts.
	 */
	private static final double INITIAL_Y_POSITION = 300.0;

	/**
	 * The height of the user plane image.
	 */
	private static final int IMAGE_HEIGHT = 150;

	/**
	 * The X-offset for the projectiles fired by the user plane.
	 */
	private static final int PROJECTILE_X_POSITION = 110;

	/**
	 * The Y-offset for the projectiles fired by the user plane.
	 */
	private static final int PROJECTILE_Y_POSITION_OFFSET = 20;

	/**
	 * The base vertical velocity of the user plane.
	 */
	private final int VERTICAL_VELOCITY = 8;

	/**
	 * The base horizontal velocity of the user plane.
	 */
	private final int HORIZONTAL_VELOCITY = 8;

	/**
	 * Multiplier for the X-direction velocity based on user input or conditions.
	 */
	private int XvelocityMultiplier;

	/**
	 * Multiplier for the Y-direction velocity based on user input or conditions.
	 */
	private int YvelocityMultiplier;

	/**
	 * The number of kills the user plane has accumulated.
	 */
	private int numberOfKills;

	/**
	 * The ability that the user plane possesses, such as invincibility or speed boost.
	 */
	private Ability ability;

	/**
	 * A flag indicating whether the user plane is in an invincible state.
	 */
	private boolean isInvincible;

	/**
	 * The character data associated with the user plane, including health, speed, and abilities.
	 */
	private CharacterData characterData;

	/**
	 * The base X velocity, taking into account the user's character speed.
	 */
	private double baseXVelocity;

	/**
	 * The base Y velocity, taking into account the user's character speed.
	 */
	private double baseYVelocity;

	/**
	 * A flag indicating whether the user's ability is currently active.
	 */
	private boolean isAbilityActive;


	/**
	 * Constructs a {@code UserPlane} instance using the provided character data.
	 *
	 * @param characterData the {@code CharacterData} containing the player's attributes, such as health and abilities.
	 */
	public UserPlane(CharacterData characterData) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, characterData.getHealth());
		this.characterData = characterData;
		this.baseXVelocity = this.characterData.getSpeed() * HORIZONTAL_VELOCITY;
		this.baseYVelocity = this.characterData.getSpeed() * VERTICAL_VELOCITY;
		this.ability = this.characterData.getAbility();

		YvelocityMultiplier = 0;
		XvelocityMultiplier = 0;
	}

	/**
	 * Updates the position of the plane based on its velocity multipliers.
	 * Ensures the plane remains within predefined boundaries.
	 */
	@Override
	public void updatePosition() {
		if (isMoving()) {
			double initialTranslateX = getTranslateX();
			double initialTranslateY = getTranslateY();
			this.moveHorizontally(baseXVelocity * XvelocityMultiplier);
			this.moveVertically(baseYVelocity * YvelocityMultiplier);
			double newXPosition = getLayoutX() + getTranslateX();
			double newYPosition = getLayoutY() + getTranslateY();
			if (newXPosition < X_UPPER_BOUND || newXPosition > X_LOWER_BOUND) {
				this.setTranslateX(initialTranslateX);
			}
			if (newYPosition < Y_UPPER_BOUND || newYPosition > Y_LOWER_BOUND) {
				this.setTranslateY(initialTranslateY);
			}
		}
	}

	/**
	 * Updates the actor, including its position and ability state.
	 */
	@Override
	public void updateActor() {
		updatePosition();
		updateAbility();
	}

	/**
	 * Fires a projectile from the player's plane.
	 *
	 * @return a new {@code UserProjectile} instance fired from the plane's position.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return new UserProjectile(PROJECTILE_X_POSITION, getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
	}

	/**
	 * Checks if the plane is currently moving.
	 *
	 * @return {@code true} if the plane is moving; {@code false} otherwise.
	 */
	private boolean isMoving() {
		return (YvelocityMultiplier != 0 || XvelocityMultiplier != 0);
	}

	/**
	 * Moves the plane upwards.
	 */
	public void moveUp() {
		YvelocityMultiplier = -1;
	}

	/**
	 * Moves the plane downwards.
	 */
	public void moveDown() {
		YvelocityMultiplier = 1;
	}

	/**
	 * Moves the plane to the left.
	 */
	public void moveLeft() {
		XvelocityMultiplier = -1;
	}

	/**
	 * Moves the plane to the right.
	 */
	public void moveRight() {
		XvelocityMultiplier = 1;
	}

	/**
	 * Updates the state of the plane's ability.
	 */
	private void updateAbility() {
		if (ability != null && isAbilityActive) {
			long currentTime = System.currentTimeMillis();
			ability.update(currentTime);

			if (!ability.isActive() && !ability.isOnCooldown()) {
				isAbilityActive = false;
			}
		}
	}

	/**
	 * Activates the player's ability, if available and not on cooldown.
	 */
	public void castAbility() {
		if (ability != null && !isAbilityActive) {
			try {
				ability.activate(this);
				isAbilityActive = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No ability assigned! / On Cooldown");
		}
	}

	/**
	 * Stops the plane's movement.
	 */
	public void stop() {
		XvelocityMultiplier = 0;
		YvelocityMultiplier = 0;
	}

	// Additional Getters and Setters

	/**
	 * Returns the number of kills achieved by the player.
	 *
	 * @return the kill count.
	 */
	public int getNumberOfKills() {
		return numberOfKills;
	}

	/**
	 * Increments the player's kill count.
	 */
	public void incrementKillCount() {
		numberOfKills++;
	}

	/**
	 * Decrements the player's kill count.
	 */
	public void decrementKillCount() {
		numberOfKills--;
	}

	/**
	 * Returns the current speed of the plane.
	 *
	 * @return the speed.
	 */
	public double getSpeed() {
		return baseYVelocity;
	}

	/**
	 * Updates the plane's speed.
	 *
	 * @param newSpeed the new speed value.
	 */
	public void setSpeed(double newSpeed) {
		baseYVelocity = newSpeed;
		baseXVelocity = newSpeed;
	}

	/**
	 * Sets the plane's invincibility state.
	 *
	 * @param invincible {@code true} to enable invincibility; {@code false} otherwise.
	 */
	public void setInvincible(boolean invincible) {
		isInvincible = invincible;
		if (invincible) {
			this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + IMAGE_NAME_INVINCIBLE).toExternalForm()));
		} else {
			this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + IMAGE_NAME).toExternalForm()));
		}
	}

	/**
	 * Returns the plane's invincibility state.
	 *
	 * @return {@code true} if the plane is invincible; {@code false} otherwise.
	 */
	public boolean getInvincibilityStatus() {
		return isInvincible;
	}
}
