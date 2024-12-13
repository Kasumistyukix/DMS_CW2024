package com.example.demo.level;

import com.example.demo.showImage.ShieldImage;
import javafx.scene.Group;

/**
 * Represents the level view for Level Two in the game.
 * This class extends from LevelView and adds specific elements for Level Two, such as a shield image.
 */
public class LevelViewLevelTwo extends LevelView {

	/**
	 * The X position of the shield image.
	 * Defines the horizontal location where the shield image will be displayed on the screen.
	 */
	private static final int SHIELD_X_POSITION = 1150;

	/**
	 * The Y position of the shield image.
	 * Defines the vertical location where the shield image will be displayed on the screen.
	 */
	private static final int SHIELD_Y_POSITION = 500;

	/**
	 * The root container for the scene.
	 * This Group object holds all the visual elements, including the shield image, to be displayed in the game.
	 */
	private final Group root;

	/**
	 * The ShieldImage object that represents the shield in the game.
	 * This object is responsible for displaying and managing the shield image.
	 */
	private final ShieldImage shieldImage;


	/**
	 * Constructs a LevelViewLevelTwo object with the specified root group and number of hearts to display.
	 *
	 * @param root The root group that will contain the visual elements of the level.
	 * @param heartsToDisplay The number of hearts to display for the player.
	 */
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
		addImagesToRoot();
	}

	/**
	 * Adds the shield image and other visual elements specific to this level to the root group.
	 */
	private void addImagesToRoot() {
		root.getChildren().addAll(shieldImage);
	}

	/**
	 * Shows the shield image on the screen.
	 */
	public void showShield() {
		shieldImage.showShield();
	}

	/**
	 * Hides the shield image from the screen.
	 */
	public void hideShield() {
		shieldImage.hideShield();
	}
}
