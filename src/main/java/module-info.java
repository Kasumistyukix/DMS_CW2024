module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo.controller;
    opens com.example.demo.enemy to javafx.fxml;
    opens com.example.demo.projectile to javafx.fxml;
    opens com.example.demo.level to javafx.fxml;
    opens com.example.demo.actor to javafx.fxml;
    opens com.example.demo.player to javafx.fxml;
    opens com.example.demo.showImage to javafx.fxml;
    exports com.example.demo;
}