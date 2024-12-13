package com.example.demo;

import com.example.demo.controller.GameController;
import com.example.demo.controller.MainMenuController;
import com.example.demo.controller.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main class serves as the entry point for the Sky Battle game application.
 * It initializes the JavaFX application and sets up the main menu scene.
 */
public class Main extends Application {

	/**
	 * The width of the application window.
	 * Defines the horizontal size of the window in pixels.
	 */
	private static final int SCREEN_WIDTH = 1300;

	/**
	 * The height of the application window.
	 * Defines the vertical size of the window in pixels.
	 */
	private static final int SCREEN_HEIGHT = 750;

	/**
	 * The title of the application window.
	 * This is displayed at the top of the window.
	 */
	private static final String TITLE = "Sky Battle";

	/**
	 * The path to the FXML file for the main menu.
	 * This file contains the layout and components for the main menu scene.
	 */
	private static final String MAIN_MENU_FXML = "/fxml/mainMenuScene.fxml";

	/**
	 * Starts the JavaFX application.
	 *
	 * @param stage The stage for the application to start the levels.
	 */
	@Override
	public void start(Stage stage) {
		try {
			SceneManager sceneManager = new SceneManager(stage);

			FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_MENU_FXML));
			loader.setController(new MainMenuController(stage, sceneManager));
			Parent root = loader.load();
			Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
			stage.setTitle(TITLE);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method launches the JavaFX application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		launch();
	}
}
