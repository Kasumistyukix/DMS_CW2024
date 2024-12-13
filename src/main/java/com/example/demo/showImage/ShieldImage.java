package com.example.demo.showImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The {@code ShieldImage} class represents a shield graphic that can be displayed
 * or hidden on the screen. This class extends {@code ImageView} and provides functionality
 * to configure the shield image's size, position, and visibility.
 */
public class ShieldImage extends ImageView {

	/** The file path to the "shield" image. */
	private static final String IMAGE_NAME = "/images/shield.png";

	/** The size (both width and height) of the shield image. */
	private static final int SHIELD_SIZE = 200;

	/**
	 * Creates a new {@code ShieldImage} instance at the specified position.
	 * The image is initially hidden and resized to a predefined size.
	 *
	 * @param xPosition the x-coordinate of the shield's position on the screen.
	 * @param yPosition the y-coordinate of the shield's position on the screen.
	 */
	public ShieldImage(double xPosition, double yPosition) {
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
		this.setImage(new Image(getClass().getResource("/com/example/demo/images/shield.png").toExternalForm()));
		this.setVisible(false);
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	/**
	 * Makes the shield image visible on the screen.
	 */
	public void showShield() {
		this.setVisible(true);
	}

	/**
	 * Hides the shield image from the screen.
	 */
	public void hideShield() {
		this.setVisible(false);
	}
}
