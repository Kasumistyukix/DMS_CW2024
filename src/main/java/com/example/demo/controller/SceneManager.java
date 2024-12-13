package com.example.demo.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager{

    /**
     * Stage object for manipulation by the manager
     */
    private final Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    /**
     * Load and display a scene from the specified FXML file.
     * @param fxmlPath Path to the FXML file.
     * @param controller Controller instance to bind with the FXML.
     * @throws IOException If the FXML file is not found or cannot be loaded.
     */
    public void switchScene(String fxmlPath, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(controller); // Set custom controller
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
