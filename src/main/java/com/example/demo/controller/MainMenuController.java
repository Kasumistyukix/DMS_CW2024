package com.example.demo.controller;

import javafx.fxml.FXML;

public class MainMenuController{

    private Controller gameController;

    public void initialize(Controller gameController){
        this.gameController = gameController;
    }

    @FXML
    public void startGame(){
        try {
            gameController.launchGame();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void exitGame(){
        try {
            gameController.launchGame();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
