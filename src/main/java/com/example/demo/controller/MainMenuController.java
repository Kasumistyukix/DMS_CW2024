package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController {

    /**
     * The SceneManager used for managing scene transitions within the application.
     * This object facilitates switching between different scenes in the game.
     */
    private final SceneManager sceneManager;

    /**
     * The main window (Stage) of the application.
     * This Stage represents the primary window for the user interface and controls the scenes displayed.
     */
    private final Stage stage;


    /**
     * Constructor for MainMenuController.
     *
     * @param stage The main window (Stage) of the application.
     * @param sceneManager The SceneManager used for switching between scenes.
     */
    public MainMenuController(Stage stage, SceneManager sceneManager) {
        this.stage = stage;
        this.sceneManager = sceneManager;
    }

    /**
     * Starts the game by switching to the character selection scene.
     *
     * This method is triggered when the player chooses to start a new game from the main menu.
     */
    @FXML
    public void startGame() {
        try {
            sceneManager.switchScene("/fxml/characterSelect.fxml", new CharacterSelectController(stage, sceneManager));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the "How To Play" scene.
     *
     * This method is triggered when the player chooses to view the instructions from the main menu.
     */
    public void howToPlay() {
        try {
            sceneManager.switchScene("/fxml/howToPlay.fxml", new CharacterSelectController(stage, sceneManager));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Exits the game.
     *
     * This method is triggered when the player chooses to exit the game from the main menu.
     */
    @FXML
    public void exitGame() {
        System.exit(0);
    }
}


