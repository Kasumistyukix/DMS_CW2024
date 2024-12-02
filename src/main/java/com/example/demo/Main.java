package com.example.demo;

import com.example.demo.controller.Controller;
import com.example.demo.controller.MainMenuController;
import com.example.demo.controller.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private static final int SCREEN_WIDTH = 1300;
	private static final int SCREEN_HEIGHT = 750;
	private static final String TITLE = "Sky Battle";
	private static final String MAIN_MENU_FXML = "/fxml/mainMenuScene.fxml";
//	private Controller myController;

	@Override
	//Scene Manager
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_MENU_FXML));
			Parent root = loader.load();

			Controller gameController = new Controller(stage);
			SceneManager sceneManager = new SceneManager(stage);

			MainMenuController mainMenuController = loader.getController();
			mainMenuController.initialize(gameController, sceneManager);

			Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
			stage.setTitle(TITLE);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch();
	}
}