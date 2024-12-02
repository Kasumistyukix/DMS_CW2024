package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CharacterSelectController {

    private Controller gameController;
    private SceneManager sceneManager;

    public CharacterSelectController(Controller gameController, SceneManager sceneManager) {
        this.gameController = gameController;
        this.sceneManager = sceneManager;
    }

    @FXML
    public void backToMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainMenuScene.fxml"));
            Parent root = loader.load();
            MainMenuController mainMenuController = loader.getController();
            mainMenuController.initialize(gameController, sceneManager);

            Scene scene = new Scene(root);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void selectCharacter1() {
        try {
            gameController.launchGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void selectCharacter2() {
        try {
            gameController.launchGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

