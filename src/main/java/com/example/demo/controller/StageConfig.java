package com.example.demo.controller;

import javafx.stage.Stage;

/**
 * A utility class for configuring the primary application window (Stage).
 * This class allows you to set various properties of the Stage such as title,
 * resizability, width, and height.
 */
public class StageConfig {

    /**
     * The main window (Stage) of the application.
     * This Stage represents the primary window where the scenes will be displayed.
     */
    private Stage stage;

    /**
     * Constructor that initializes the StageConfig with a specific Stage.
     * @param stage The Stage instance to be configured.
     */
    public StageConfig(Stage stage) {
        this.stage = stage;
    }

    /**
     * Configures the Stage with the specified title, resizability, width, and height.
     * @param title The title of the application window.
     * @param resizable Whether the window can be resized by the user.
     * @param width The width of the application window.
     * @param height The height of the application window.
     */
    public void configure(String title, boolean resizable, int width, int height) {
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
