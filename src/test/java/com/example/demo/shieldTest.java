package com.example.demo;

import com.example.demo.showImage.ShieldImage;
import javafx.application.Platform;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class shieldTest {
    @Test
    void shieldActivationTest() {
        Platform.runLater(() -> {
            // Arrange: Create an instance of ShieldImage
            ShieldImage shield = new ShieldImage(100, 200);

            // Act: Show the shield
            shield.showShield();

            // Assert: Verify the shield is visible
            assertTrue(shield.isVisible(), "Shield should be visible after calling showShield()");

            // Act: Hide the shield
            shield.hideShield();

            // Assert: Verify the shield is not visible
            assertFalse(shield.isVisible(), "Shield should not be visible after calling hideShield()");
        });

        // Pause to ensure JavaFX operations are executed
        try {
            Thread.sleep(500); // Allow JavaFX thread to process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
