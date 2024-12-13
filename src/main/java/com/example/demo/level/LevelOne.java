package com.example.demo.level;

import com.example.demo.actor.ActiveActorDestructible;
import com.example.demo.enemy.EnemyPlane;
import com.example.demo.player.CharacterData;
import com.example.demo.player.UserPlane;

/**
 * LevelOne is the first level in the game, managing the player’s interaction with enemies and handling the transition to the next level.
 * It contains the game logic for spawning enemies, checking the game's win/lose conditions, and managing the user’s progress.
 */
public class LevelOne extends LevelParent {

	/**
	 * The file path to the background image for this level.
	 * Specifies the background image used for LevelOne.
	 */
	private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg";

	/**
	 * The name of the next level class to transition to after this level.
	 * This value is used to load the next level after the player meets the required conditions.
	 */
	private static final String NEXT_LEVEL = "com.example.demo.level.LevelTwo";

	/**
	 * The total number of enemies to spawn in the level.
	 * Specifies the maximum number of enemies that should appear in this level.
	 */
	private static final int TOTAL_ENEMIES = 5;

	/**
	 * The number of kills the player must achieve to advance to the next level.
	 * This is the kill target that triggers the transition to the next level.
	 */
	private static final int KILLS_TO_ADVANCE = 10;

	/**
	 * The probability of spawning an enemy at each possible spawn point.
	 * A value between 0 and 1, determining the likelihood of an enemy being spawned at any given moment.
	 */
	private static final double ENEMY_SPAWN_PROBABILITY = .20;

	/**
	 * The character data associated with the player in this level.
	 * Holds information about the player's health, speed, and abilities.
	 */
	private CharacterData CHARACTER_DATA;

	/**
	 * The player’s plane (UserPlane) object for this level.
	 * Represents the user's character in the game.
	 */
	private UserPlane Player;

	/**
	 * Constructor for LevelOne.
	 * Initializes the level with the specified screen dimensions and player character data.
	 *
	 * @param screenHeight The height of the screen.
	 * @param screenWidth The width of the screen.
	 * @param characterData The data associated with the player character, including health and abilities.
	 */
	public LevelOne(double screenHeight, double screenWidth, CharacterData characterData) {
		super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, characterData);
		CHARACTER_DATA = characterData;
	}

	/**
	 * Checks if the game is over based on the player’s status and progress.
	 * If the player is destroyed or has reached the required kill count, the game ends or progresses.
	 */
	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();  // Ends the game if the user is destroyed.
		} else if (userHasReachedKillTarget()) {
			goToNextLevel(NEXT_LEVEL);  // Transitions to the next level if the player reaches the kill target.
		}
	}

	/**
	 * Initializes friendly units, such as the player's plane.
	 * Adds the user's plane to the root of the scene.
	 */
	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
	}

	/**
	 * Spawns enemy units at random locations within the level.
	 * The number of spawned enemies is limited by the TOTAL_ENEMIES constant and the spawn probability.
	 */
	@Override
	protected void spawnEnemyUnits() {
		int currentNumberOfEnemies = getCurrentNumberOfEnemies();
		for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
			if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
				double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
				ActiveActorDestructible newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
				addEnemyUnit(newEnemy);  // Adds the new enemy to the level.
			}
		}
	}

	/**
	 * Instantiates the LevelView for this level.
	 * Provides the visual components, such as background and health display, for the level.
	 *
	 * @return A new LevelView instance for this level.
	 */
	@Override
	protected LevelView instantiateLevelView() {
		return new LevelView(getRoot(), CHARACTER_DATA.getHealth());
	}

	/**
	 * Checks if the player has reached the required number of kills to advance to the next level.
	 *
	 * @return True if the player has achieved the required number of kills, false otherwise.
	 */
	private boolean userHasReachedKillTarget() {
		return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
	}

}

