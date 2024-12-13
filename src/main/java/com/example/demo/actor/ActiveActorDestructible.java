package com.example.demo.actor;

/**
 * {@code ActiveActorDestructible} is an abstract class that extends {@link ActiveActor} and implements the {@link Destructible} interface.
 * It represents an actor that can be destroyed and removed from the game. This class adds functionality for handling destruction
 * and the reason for the actor's removal, in addition to the basic movement and rendering functionality from {@link ActiveActor}.
 */
public abstract class ActiveActorDestructible extends ActiveActor implements Destructible {

	private boolean isDestroyed;
	private RemovalReason removalReason;

	/**
	 * Constructs a new {@code ActiveActorDestructible} with the specified image, height, and initial position.
	 * This actor can be destroyed and has additional behavior compared to a standard {@link ActiveActor}.
	 *
	 * @param imageName The name of the image file (should be in the {@code /com/example/demo/images/} directory).
	 * @param imageHeight The height to which the image should be resized.
	 * @param initialXPos The initial horizontal position (X coordinate) of the actor.
	 * @param initialYPos The initial vertical position (Y coordinate) of the actor.
	 */
	public ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		isDestroyed = false;
	}

	/**
	 * Abstract method to be implemented by subclasses to define how the position of the destructible actor is updated.
	 */
	@Override
	public abstract void updatePosition();

	/**
	 * Abstract method to be implemented by subclasses to define how the destructible actor behaves or updates each frame.
	 */
	public abstract void updateActor();

	/**
	 * Handles the damage taken by the actor. This method should be implemented by subclasses to define the logic for taking damage.
	 */
	@Override
	public abstract void takeDamage();

	/**
	 * Marks the actor as destroyed and initiates any required destruction behavior.
	 * This method sets the {@code isDestroyed} flag to true.
	 */
	@Override
	public void destroy() {
		setDestroyed(true);
	}

	/**
	 * Marks the actor for removal by setting a removal reason and calling the {@code destroy()} method to mark it as destroyed.
	 *
	 * @param reason The reason for the actor's removal.
	 */
	public void markRemoval(RemovalReason reason) {
		this.removalReason = reason;
		destroy();
	}

	/**
	 * Returns the reason for the actor's removal.
	 *
	 * @return The removal reason.
	 */
	public RemovalReason getRemovalReason() {
		return removalReason;
	}

	/**
	 * Sets the {@code isDestroyed} flag to indicate whether the actor has been destroyed.
	 *
	 * @param isDestroyed The new destroyed state of the actor.
	 */
	protected void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	/**
	 * Returns whether the actor is destroyed.
	 *
	 * @return {@code true} if the actor is destroyed, otherwise {@code false}.
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}
}
