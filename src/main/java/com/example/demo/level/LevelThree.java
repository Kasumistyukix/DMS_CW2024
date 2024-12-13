package com.example.demo.level;

import com.example.demo.actor.ActiveActorDestructible;
import com.example.demo.enemy.Boss;
import com.example.demo.enemy.EnemyPlane;
import com.example.demo.player.CharacterData;

public class LevelThree extends LevelParent {

    /**
     * The file path for the background image used in the level.
     * Specifies the location of the background image that will be displayed in the level.
     */
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg";

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
     * The total number of enemies in the level.
     * Specifies the maximum number of enemies that can be present in the level at any given time.
     */
    private static final int TOTAL_ENEMIES = 5;

    /**
     * The probability of an enemy being spawned during gameplay.
     * A value between 0 and 1 indicating the likelihood of a new enemy appearing in the game at each time step.
     */
    private static final double ENEMY_SPAWN_PROBABILITY = .03;

    /**
     * The level view for level two of the game.
     * This object manages the visual representation and UI elements specific to level two, including background, images, and interactions.
     */
    private LevelViewLevelTwo levelView;

    public LevelThree(double screenHeight, double screenWidth, CharacterData characterData) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, characterData);
        boss = new Boss();
        boss.setBossHP(50);
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
            winGame();
        }
    }

    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies() == 0) {
            addEnemyUnit(boss);
            getRoot().getChildren().add(boss.shieldImage());
        }

        int currentNumberOfEnemies = getCurrentNumberOfEnemies();
        for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
            if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
        }
    }

    @Override
    protected LevelView instantiateLevelView() {
        levelView = new LevelViewLevelTwo(getRoot(), CHARACTER_DATA.getHealth());
        return levelView;
    }

}
