//package com.example.demo;
//
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.junit.jupiter.api.Test;
//import org.testfx.framework.junit5.ApplicationTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MainTest extends ApplicationTest {
//
//    private Stage primaryStage;
//
//    @Override
//    public void start(Stage stage) {
//        // Launch the application
//        Main main = new Main();
//        primaryStage = stage;
//        main.start(stage);
//    }
//
//    @Test
//    public void testMainMenuSceneLoad() {
//        // Verify stage title
//        assertEquals("Sky Battle", primaryStage.getTitle(), "The stage title is incorrect.");
//
//        // Verify scene dimensions
//        Scene scene = primaryStage.getScene();
//        assertNotNull(scene, "The scene should not be null.");
//        assertEquals(1300, scene.getWidth(), "The scene width is incorrect.");
//        assertEquals(750, scene.getHeight(), "The scene height is incorrect.");
//
//        // Verify the main menu controller loaded correctly
//        assertTrue(scene.getRoot().lookup("#mainMenuPane") != null,
//                "The main menu FXML did not load properly (root element not found).");
//    }
//}
