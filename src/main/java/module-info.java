/**
 * The `com.example.demo` module defines the application's module structure.
 * It requires necessary JavaFX libraries and opens packages for reflection-based
 * operations like loading FXML files. The module also exports several packages 
 * to allow other modules or components to access them.
 */
module com.example.demo {

    /**
     * Requires JavaFX controls module for UI components like buttons, labels, etc.
     */
    requires javafx.controls;

    /**
     * Requires JavaFX FXML module for loading and handling FXML files for the user interface.
     */
    requires javafx.fxml;

    /**
     * Optionally, this module can require the JavaFX media module if media-related features are used.
     * Currently commented out.
     */
//    requires javafx.media;

    /**
     * Opens the com.example.demo package to JavaFX for reflection-based loading of FXML files.
     */
    opens com.example.demo to javafx.fxml;

    /**
     * Exports the com.example.demo.controller package for use by other modules or components.
     */
    exports com.example.demo.controller;

    /**
     * Opens the com.example.demo.enemy package to JavaFX for FXML loading.
     */
    opens com.example.demo.enemy to javafx.fxml;

    /**
     * Opens the com.example.demo.projectile package to JavaFX for FXML loading.
     */
    opens com.example.demo.projectile to javafx.fxml;

    /**
     * Opens the com.example.demo.level package to JavaFX for FXML loading.
     */
    opens com.example.demo.level to javafx.fxml;

    /**
     * Opens the com.example.demo.actor package to JavaFX for FXML loading.
     */
    opens com.example.demo.actor to javafx.fxml;

    /**
     * Opens the com.example.demo.player package to JavaFX for FXML loading.
     */
    opens com.example.demo.player to javafx.fxml;

    /**
     * Opens the com.example.demo.showImage package to JavaFX for FXML loading.
     */
    opens com.example.demo.showImage to javafx.fxml;

    /**
     * Exports the com.example.demo package for general access by other modules or components.
     */
    exports com.example.demo;

    /**
     * Exports the com.example.demo.player package for access by other modules or components.
     */
    exports com.example.demo.player;

    /**
     * Exports the com.example.demo.abilities package for use by other modules or components.
     */
    exports com.example.demo.abilities;

    /**
     * Exports the com.example.demo.utility package for use by other modules or components.
     */
    exports com.example.demo.utility;
}
