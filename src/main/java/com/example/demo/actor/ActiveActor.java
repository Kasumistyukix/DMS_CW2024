package com.example.demo.actor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * {@code ActiveActor} is an abstract class representing an actor that has an image
 * and can move within the scene. It extends {@link ImageView} and provides functionality
 * for setting the image and managing the position of the actor.
 */
public abstract class ActiveActor extends ImageView {

	private static final String IMAGE_LOCATION = "/com/example/demo/images/";

	/**
	 * Constructs a new {@code ActiveActor} with the specified image, height, and initial position.
	 * The image is loaded from the specified location and displayed with the provided size.
	 *
	 * @param imageName The name of the image file (should be in the {@code /com/example/demo/images/} directory).
	 * @param imageHeight The height to which the image should be resized.
	 * @param initialXPos The initial horizontal position (X coordinate) of the actor.
	 * @param initialYPos The initial vertical position (Y coordinate) of the actor.
	 */
	public ActiveActor(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		// Load the image from the resources and set it as the ImageView's image.
		this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + imageName).toExternalForm()));

		// Set the actor's initial position and size.
		this.setLayoutX(initialXPos);
		this.setLayoutY(initialYPos);
		this.setFitHeight(imageHeight);
		this.setPreserveRatio(true); // Ensure the aspect ratio is preserved when resizing.
	}

	/**
	 * Abstract method to be implemented by subclasses to define how the actor's position is updated.
	 */
	public abstract void updatePosition();

	/**
	 * Moves the actor horizontally by the specified amount.
	 * This method updates the actor's X position relative to its current position.
	 *
	 * @param horizontalMove The distance to move horizontally.
	 */
	protected void moveHorizontally(double horizontalMove) {
		this.setTranslateX(getTranslateX() + horizontalMove);
	}

	/**
	 * Moves the actor vertically by the specified amount.
	 * This method updates the actor's Y position relative to its current position.
	 *
	 * @param verticalMove The distance to move vertically.
	 */
	protected void moveVertically(double verticalMove) {
		this.setTranslateY(getTranslateY() + verticalMove);
	}
}
