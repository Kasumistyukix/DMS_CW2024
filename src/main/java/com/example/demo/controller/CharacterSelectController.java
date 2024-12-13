package com.example.demo.controller;

import com.example.demo.player.CharacterData;
import com.example.demo.player.CharacterRepository;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Controller for the character selection screen in the game.
 * Handles the selection of characters and navigation to other scenes.
 */
public class CharacterSelectController {

    /**
     * The current stage of the application.
     */
    private Stage stage;

    /**
     * The scene manager responsible for scene transitions.
     */
    private SceneManager sceneManager;

    /**
     * Controller for managing the game logic.
     */
    private GameController gameController;

    /**
     * The currently selected character.
     */
    private CharacterData selectedCharacter;

    /**
     * Constructor for the CharacterSelectController class.
     * Initializes the stage, scene manager, and game controller.
     *
     * @param stage The stage for the current window.
     * @param sceneManager The scene manager to handle scene transitions.
     */
    public CharacterSelectController(Stage stage, SceneManager sceneManager) {
        this.stage = stage;
        this.sceneManager = sceneManager;
        this.gameController = new GameController(stage);
    }

    /**
     * Navigates back to the main menu scene.
     */
    @FXML
    public void backToMenu() {
        try {
            sceneManager.switchScene("/fxml/mainMenuScene.fxml", new MainMenuController(stage, sceneManager));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects the first character and launches the game with the selected character.
     */
    @FXML
    public void selectCharacter1() {
        try {
            selectedCharacter = selectCharacter("Laughing Fox");
            gameController.launchGame(selectedCharacter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects the second character and launches the game with the selected character.
     */
    @FXML
    public void selectCharacter2() {
        try {
            selectedCharacter = selectCharacter("Flame Ogre");
            gameController.launchGame(selectedCharacter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects a character based on the provided name.
     * Retrieves the character from the repository.
     *
     * @param characterName The name of the character to select.
     * @return The CharacterData object for the selected character, or null if the character is not found.
     */
    public CharacterData selectCharacter(String characterName) {
        CharacterData selectedCharacter = CharacterRepository.getCharacter(characterName);
        try {
            if (selectedCharacter != null) {
                System.out.println("Character selected: " + selectedCharacter.getName());
            } else {
                System.out.println("Character not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedCharacter;
    }
}
