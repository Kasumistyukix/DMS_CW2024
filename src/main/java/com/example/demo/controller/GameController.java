package com.example.demo.controller;

import com.example.demo.level.LevelOne;
import com.example.demo.level.LevelParent;
import com.example.demo.player.CharacterData;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Controller responsible for managing the flow of the game.
 * It handles the initialization and transition of levels, as well as storing the selected character's data.
 */
public class GameController implements Observer {

	/**
	 * The `LEVEL_ONE_CLASS_NAME` constant stores the full class name for the first level in the game.
	 * This is used to dynamically load the level class at runtime.
	 */
	private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.level.LevelOne"; // Full class name for LevelOne

	/**
	 * The `stage` represents the main window (Stage) of the application where the game is displayed.
	 * It is used to set the scene and show the game content to the user.
	 */
	private final Stage stage; // The main stage (window) of the application

	/**
	 * The `selectedCharacterData` holds the data of the character selected by the player.
	 * This data includes information such as the character's health, abilities, and other relevant attributes.
	 */
	private CharacterData selectedCharacterData; // Store the selected character data


	/**
	 * Constructor for the GameController class.
	 * Initializes the stage for the game and prepares the controller to manage game flow.
	 *
	 * @param stage The main stage for the game application window.
	 */
	public GameController(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Launches the game by setting up the selected character and initializing the first level.
	 *
	 * @param characterData The data of the character selected by the player.
	 * @throws ClassNotFoundException If the level class cannot be found.
	 * @throws NoSuchMethodException If the constructor of the level class is not found.
	 * @throws InstantiationException If the level class cannot be instantiated.
	 * @throws IllegalAccessException If the constructor is not accessible.
	 * @throws InvocationTargetException If an exception is thrown during the constructor invocation.
	 */
	public void launchGame(CharacterData characterData) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		this.selectedCharacterData = characterData; // Store the selected character data
		stage.show(); // Display the stage
		goToLevel(LEVEL_ONE_CLASS_NAME); // Transition to the first level
	}

	/**
	 * Initializes and transitions to the specified level.
	 * Uses reflection to dynamically load and initialize the level class.
	 *
	 * @param className The name of the class representing the level to transition to.
	 * @throws ClassNotFoundException If the level class cannot be found.
	 * @throws NoSuchMethodException If the constructor of the level class is not found.
	 * @throws InstantiationException If the level class cannot be instantiated.
	 * @throws IllegalAccessException If the constructor is not accessible.
	 * @throws InvocationTargetException If an exception is thrown during the constructor invocation.
	 */
	private void goToLevel(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> myClass = Class.forName(className); // Load the class by name
		Constructor<?> constructor = myClass.getConstructor(double.class, double.class, CharacterData.class); // Get the constructor
		LevelParent myLevel = (LevelParent) constructor.newInstance(stage.getScene().getHeight(), stage.getScene().getWidth(), selectedCharacterData); // Create the level instance
		myLevel.initializeLevelView(); // Initialize the level view
		myLevel.addObserver(this); // Add this controller as an observer for the level
		Scene scene = myLevel.initializeScene(); // Initialize the scene for the level
		stage.setScene(scene); // Set the scene to the stage
		myLevel.startGame(); // Start the game for the level
	}

	/**
	 * Called when the observed level signals that it is ready to transition to the next level.
	 *
	 * @param arg0 The observable object (level).
	 * @param arg1 The argument passed by the level (usually the next level's class name).
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			goToLevel((String) arg1); // Transition to the next level
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// Display an error alert if there is an issue with transitioning to the next level
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getClass().toString());
			alert.show();
		}
	}
}
