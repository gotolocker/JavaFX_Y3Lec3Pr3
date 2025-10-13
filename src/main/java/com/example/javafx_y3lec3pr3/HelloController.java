package com.example.javafx_y3lec3pr3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void btnShow_Click() {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Bestie");
        info.setHeaderText("A?");
        info.setContentText("sth inside");
    }
}
