package com.example.demo.level;

import com.example.demo.player.HeartDisplay;
import com.example.demo.showImage.GameOverImage;
import com.example.demo.showImage.WinImage;
import javafx.scene.Group;

public class LevelView {

	/**
	 * The X position for displaying the heart display.
	 * Defines the horizontal location where the heart display will appear on the screen.
	 */
	private static final double HEART_DISPLAY_X_POSITION = 5;

	/**
	 * The Y position for displaying the heart display.
	 * Defines the vertical location where the heart display will appear on the screen.
	 */
	private static final double HEART_DISPLAY_Y_POSITION = 25;

	/**
	 * The X position for displaying the win image.
	 * Specifies where the win image will be positioned on the screen when the player wins.
	 */
	private static final int WIN_IMAGE_X_POSITION = 355;

	/**
	 * The Y position for displaying the win image.
	 * Specifies where the win image will be positioned on the screen when the player wins.
	 */
	private static final int WIN_IMAGE_Y_POSITION = 175;

	/**
	 * The X position for displaying the loss screen.
	 * Specifies where the loss screen image will be positioned on the screen when the player loses.
	 */
	private static final int LOSS_SCREEN_X_POSITION = 355;

	/**
	 * The Y position for displaying the loss screen.
	 * Specifies where the loss screen image will be positioned on the screen when the player loses.
	 */
	private static final int LOSS_SCREEN_Y_POSITION = 175;

	/**
	 * The root container for the scene.
	 * This Group object holds all the visual elements, such as the win image, game over image, and heart display, to be displayed in the game.
	 */
	private final Group root;

	/**
	 * The WinImage object that represents the win screen.
	 * This object manages the win image display and can be shown when the player wins the game.
	 */
	private final WinImage winImage;

	/**
	 * The GameOverImage object that represents the game over screen.
	 * This object manages the game over image display and can be shown when the player loses the game.
	 */
	private final GameOverImage gameOverImage;

	/**
	 * The HeartDisplay object that represents the player's health.
	 * This object manages the heart images displayed to indicate the player's remaining health.
	 */
	private final HeartDisplay heartDisplay;

	
	public LevelView(Group root, int heartsToDisplay) {
		this.root = root;
		this.heartDisplay = new HeartDisplay(HEART_DISPLAY_X_POSITION, HEART_DISPLAY_Y_POSITION, heartsToDisplay);
		this.winImage = new WinImage(WIN_IMAGE_X_POSITION, WIN_IMAGE_Y_POSITION);
		this.gameOverImage = new GameOverImage(LOSS_SCREEN_X_POSITION, LOSS_SCREEN_Y_POSITION);
	}
	
	public void showHeartDisplay() {
		root.getChildren().add(heartDisplay.getContainer());
	}

	public void showWinImage() {
		root.getChildren().add(winImage);
		winImage.showWinImage();
	}
	
	public void showGameOverImage() {
		root.getChildren().add(gameOverImage);
		gameOverImage.showGameOverImage();
	}
	
	public void removeHearts(int heartsRemaining) {
		int currentNumberOfHearts = heartDisplay.getContainer().getChildren().size();
		for (int i = 0; i < currentNumberOfHearts - heartsRemaining; i++) {
			heartDisplay.removeHeart();
		}
	}

}
