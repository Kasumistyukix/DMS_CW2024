package com.example.demo.controller;

import javafx.fxml.FXML;

public class MainMenuController {

    private Controller gameController;
    private SceneManager sceneManager;

    public void initialize(Controller gameController, SceneManager sceneManager) {
        this.gameController = gameController;
        this.sceneManager = sceneManager;
    }

    @FXML
    public void startGame() {
        try {
            sceneManager.switchScene("/fxml/characterSelect.fxml",new CharacterSelectController(gameController, sceneManager));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitGame() {
        System.exit(0);
    }
}

