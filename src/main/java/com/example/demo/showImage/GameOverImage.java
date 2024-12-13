package com.example.demo.showImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The {@code GameOverImage} class represents a image displayed when the player loses the game
 * This class extends {@code ImageView} and provides functionality
 * to configure the image's size, position, and visibility.
 */
public class GameOverImage extends ImageView {

	/** The file path to the "Game Over" image. */
	private static final String IMAGE_NAME = "/com/example/demo/images/gameover.png";

	/** The height of the "Game Over" image. */
	private static final int HEIGHT = 500;

	/** The width of the "Game Over" image. */
	private static final int WIDTH = 600;

	/**
	 * Creates a new {@code GameOverImage} instance at the specified position.
	 * The image is initially hidden and resized to predefined width and height.
	 *
	 * @param xPosition the x-coordinate of the image's position on the screen.
	 * @param yPosition the y-coordinate of the image's position on the screen.
	 */
	public GameOverImage(double xPosition, double yPosition) {
		setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
		setLayoutX(xPosition);
		setLayoutY(yPosition);
		this.setVisible(false);
		this.setFitHeight(HEIGHT);
		this.setFitWidth(WIDTH);
	}

	/**
	 * Makes the "Game Over" image visible on the screen.
	 */
	public void showGameOverImage() {
		this.setVisible(true);
	}
}
