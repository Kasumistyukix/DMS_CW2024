package com.example.demo.controller;

import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	private static final int SCREEN_WIDTH = 1300;
	private static final int SCREEN_HEIGHT = 750;
	private static final String TITLE = "Sky Battle";
	private static final String MAIN_MENU_FXML = "/fxml/mainMenuScene.fxml";
//	private Controller myController;

	@Override
	public void start(Stage stage){//throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(MAIN_MENU_FXML));
			Parent root = loader.load();
			Controller GameController = new Controller(stage);
			MainMenuController mainMenuController = loader.getController();
			mainMenuController.initialize(GameController);

			Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
			stage.setTitle(TITLE);
			stage.setResizable(false);
			stage.setHeight(SCREEN_HEIGHT);
			stage.setWidth(SCREEN_WIDTH);
			stage.setScene(scene);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}
}