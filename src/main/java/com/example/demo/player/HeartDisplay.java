package com.example.demo.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class HeartDisplay {

	/**
	 * Path to the heart image file used for displaying health.
	 */
	private static final String HEART_IMAGE_NAME = "/com/example/demo/images/heart.png";

	/**
	 * The height of the heart image in pixels.
	 */
	private static final int HEART_HEIGHT = 50;

	/**
	 * Index for removing the first heart from the display.
	 */
	private static final int INDEX_OF_FIRST_ITEM = 0;

	/**
	 * The container holding the heart images in a horizontal layout.
	 */
	private HBox container;

	/**
	 * The X position of the heart container on the screen.
	 */
	private double containerXPosition;

	/**
	 * The Y position of the heart container on the screen.
	 */
	private double containerYPosition;

	/**
	 * The number of hearts to initially display.
	 */
	private int numberOfHeartsToDisplay;
	
	/**
	 * Constructs a HeartDisplay at the given position with the specified number of hearts.
	 *
	 * @param xPosition The X position of the heart display on the screen.
	 * @param yPosition The Y position of the heart display on the screen.
	 * @param heartsToDisplay The initial number of hearts to display.
	 */
	public HeartDisplay(double xPosition, double yPosition, int heartsToDisplay) {
		this.containerXPosition = xPosition;
		this.containerYPosition = yPosition;
		this.numberOfHeartsToDisplay = heartsToDisplay;
		initializeContainer();
		initializeHearts();
	}
	/**
	 * Initializes the container that holds the heart images.
	 * Sets the container's position on the screen.
	 */
	private void initializeContainer() {
		container = new HBox();
		container.setLayoutX(containerXPosition);
		container.setLayoutY(containerYPosition);
	}
	/**
	 * Initializes the heart images and adds them to the container.
	 * Each heart image is added as an ImageView in the container.
	 */
	private void initializeHearts() {
		for (int i = 0; i < numberOfHeartsToDisplay; i++) {
			ImageView heart = new ImageView(new Image(getClass().getResource(HEART_IMAGE_NAME).toExternalForm()));

			heart.setFitHeight(HEART_HEIGHT);
			heart.setPreserveRatio(true);
			container.getChildren().add(heart);
		}
	}
	/**
	 * Removes the first heart from the heart display container.
	 * This method is called when the player loses a health point.
	 */
	public void removeHeart() {
		if (!container.getChildren().isEmpty())
			container.getChildren().remove(INDEX_OF_FIRST_ITEM);
	}
	/**
	 * Returns the container holding the heart images.
	 * This container can be added to the JavaFX scene graph.
	 *
	 * @return The HBox container holding the heart images.
	 */
	public HBox getContainer() {
		return container;
	}

}
