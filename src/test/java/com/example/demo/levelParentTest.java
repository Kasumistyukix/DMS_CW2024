package com.example.demo;

import javafx.animation.Timeline;
import javafx.animation.Animation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelOneTest {

    @Test
    void testGoToNextLevelStopsTimeline() {
        // Arrange
        LevelOne levelOne = new LevelOne();  // Create an instance of LevelOne
        Timeline timeline = new Timeline();  // Create a Timeline object
        timeline.play();  // Simulate the timeline running
//        levelOne.setTimeline(timeline);  // Inject the timeline into levelOne

        // Act
        levelOne.goToNextLevel("com.example.demo.LevelTwo");  // Transition to the next level

        // Assert
        assertFalse(timeline.getStatus() == Animation.Status.RUNNING,
                "Timeline should be stopped when transitioning to the next level.");
    }
}
