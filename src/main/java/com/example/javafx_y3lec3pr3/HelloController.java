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
        cbType.setItems(types);
    }

    public abstract class Planet{
        private String _name;
        protected String _type;
        private double _radius;
        private double _weight;
        private double _amount;
        private double _distance;

        public Planet(String name,  double radius, double weight, double amount, double distance){

            this._name = name;
            this._radius = radius;
            this._weight = weight;
            this._amount = amount;
            this._distance = distance;

        }
    }
    public class EarthTypePlanet extends Planet{
        public EarthTypePlanet(String name, double radius, double weight, double amount, double distance){
            super(name, radius, weight, amount, distance);
            this._type = "Земной тип";
        }
    }
    public class GasGiant extends Planet{
        public GasGiant(String name, double radius, double weight, double amount, double distance){
            super(name, radius, weight, amount, distance);
            this._type = "Газовый гигант";
        }
    }
    public class IceGiant extends Planet{
        public IceGiant(String name, double radius, double weight, double amount, double distance){
            super(name, radius, weight, amount, distance);
            this._type = "Ледяной гигант";
        }
    }
    public class DwarfPlanets extends Planet{
        public DwarfPlanets(String name, double radius, double weight, double amount, double distance){
            super(name, radius, weight, amount, distance);
            this._type = "Карликовая планета";
        }
    }
}
