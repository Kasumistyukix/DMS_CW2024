package com.example.demo.controller;

import javafx.stage.Stage;

public class StageConfig {
    private Stage stage;

    public StageConfig(Stage stage) {
        this.stage = stage;
    }

    public void configure(String title, boolean resizable, int width, int height) {
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
