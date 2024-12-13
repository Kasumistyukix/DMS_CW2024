package com.example.demo.showImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The {@code WinImage} class represents an image displayed when the player wins the game.
 * This class extends {@code ImageView} and provides functionality
 * to configure the image's size, position, and visibility.
 */
public class WinImage extends ImageView {

	/** The file path to the "You Win" image. */
	private static final String IMAGE_NAME = "/com/example/demo/images/youwin.png";

	/** The height of the "You Win" image. */
	private static final int HEIGHT = 500;

	/** The width of the "You Win" image. */
	private static final int WIDTH = 600;

	/**
	 * Creates a new {@code WinImage} instance at the specified position.
	 * The image is initially hidden and resized to fit the predefined width and height.
	 *
	 * @param xPosition the x-coordinate of the image's position on the screen.
	 * @param yPosition the y-coordinate of the image's position on the screen.
	 */
	public WinImage(double xPosition, double yPosition) {
		this.setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
		this.setVisible(false);
		this.setFitHeight(HEIGHT);
		this.setFitWidth(WIDTH);
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
	}

	/**
	 * Makes the "You Win" image visible.
	 */
	public void showWinImage() {
		this.setVisible(true);
	}
}

