//package com.example.demo.controller;
//
//import com.example.demo.level.LevelParent
//import javafx.animation.Timeline;
//import javafx.animation.Animation;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public Class LevelParentTest {
//
//    @Test
//    void testGoToNextLevelStopsTimeline() {
//        // Arrange
//        LevelParent levelParent = new LevelParent(1300,750);  // Create an instance of LevelOne
//        Timeline timeline = new Timeline();  // Create a Timeline object
//        timeline.play();  // Simulate the timeline running
////        levelOne.setTimeline(timeline);  // Inject the timeline into levelOne
//
//        // Act
//        levelParent.goToNextLevel("com.example.demo.level.LevelTwo");  // Transition to the next level
//
//        // Assert
//        assertFalse(timeline.getStatus() == Animation.Status.RUNNING,
//                "Timeline should be stopped when transitioning to the next level.");
//    }
//}
