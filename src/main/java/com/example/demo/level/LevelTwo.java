package com.example.demo.level;

import com.example.demo.enemy.Boss;
import com.example.demo.player.CharacterData;

public class LevelTwo extends LevelParent {

	/**
	 * The file path for the background image used in the level.
	 * Specifies the location of the background image that will be displayed in the level.
	 */
	private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";

	/**
	 * The class name for the next level in the game.
	 * Represents the fully qualified class name of the next level to be loaded when the current level is completed.
	 */
	private static final String NEXT_LEVEL = "com.example.demo.level.LevelThree";

	/**
	 * The character data associated with the player.
	 * This object holds information about the player's characteristics, such as health, speed, and ability.
	 */
	private CharacterData CHARACTER_DATA;

	/**
	 * The Boss object representing the boss character in the game.
	 * This object manages the boss's behavior, health, and interactions with the player during the level.
	 */
	private final Boss boss;

	/**
	 * The level view for level two of the game.
	 * This object manages the visual representation and UI elements specific to level two, including background, images, and interactions.
	 */
	private LevelViewLevelTwo levelView;

	public LevelTwo(double screenHeight, double screenWidth, CharacterData characterData) {
		super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, characterData);
		boss = new Boss();
		CHARACTER_DATA = characterData;
	}

	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
	}

	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
		}
		else if (boss.isDestroyed()) {
			goToNextLevel(NEXT_LEVEL);
		}
	}

	@Override
	protected void spawnEnemyUnits() {
		if (getCurrentNumberOfEnemies() == 0) {
			addEnemyUnit(boss);
			getRoot().getChildren().add(boss.shieldImage());
		}
	}

	@Override
	protected LevelView instantiateLevelView() {
		levelView = new LevelViewLevelTwo(getRoot(), CHARACTER_DATA.getHealth());
		return levelView;
	}

}
