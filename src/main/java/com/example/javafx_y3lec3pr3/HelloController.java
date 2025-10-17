package com.example.javafx_y3lec3pr3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    ObservableList<Planet> planets = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> types = FXCollections.observableArrayList("Земной тип", "Газовый гигант", "Ледяной гигант", "Карликовая планета");

    @FXML
    public ComboBox<String> cbType;

    @FXML
    protected void btnShow_Click(javafx.event.ActionEvent actionEvent) {

        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Bestie");
        info.setHeaderText("Who r ur Bestie?");

        info.setContentText("sth inside");
        info.show();
    }

    @FXML
    protected void initialize(){
        cbType.setItems(types);
    }

    @FXML
    protected void Add (javafx.event.ActionEvent actionEvent){

    }

}
