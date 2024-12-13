package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;


/**
 * The `HowToPlayController` class handles the functionality for the "How to Play" screen in the game.
 * It allows the user to navigate back to the main menu from the How-to-Play screen.
 */
public class HowToPlayController {

    /**
     * The main window (Stage) of the application.
     * This Stage represents the window where all scenes are displayed.
     */
    private Stage stage;

    /**
     * The scene manager used to switch between scenes.
     * This manages the transitions between different screens in the application.
     */
    private SceneManager sceneManager;

    /**
     * The game controller used to manage game flow.
     * This controller handles the initiation and control of the game, including scene transitions and game logic.
     */
    private GameController gameController;


    /**
     * Constructor for the `HowToPlayController` class.
     * Initializes the controller with the main stage, scene manager, and game controller.
     *
     * @param stage The main application window (Stage)
     * @param sceneManager The manager for switching scenes
     */
    public HowToPlayController(Stage stage, SceneManager sceneManager) {
        this.stage = stage;
        this.sceneManager = sceneManager;
        this.gameController = new GameController(stage);
    }

    /**
     * Handles the action of returning to the main menu.
     * This method is triggered when the user selects the "Back to Menu" button.
     * It switches the scene to the main menu.
     */
    @FXML
    public void backToMenu() {
        try {
            // Switches to the main menu scene
            sceneManager.switchScene("/fxml/mainMenuScene.fxml", new MainMenuController(stage, sceneManager));
        } catch (Exception e) {
            e.printStackTrace(); // Handles any exceptions that might occur while switching scenes
        }
    }
}
