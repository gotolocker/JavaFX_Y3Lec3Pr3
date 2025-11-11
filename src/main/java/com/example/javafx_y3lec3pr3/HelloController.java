package com.example.javafx_y3lec3pr3;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    ObservableList<Planet> planets = FXCollections.observableArrayList();
    public ObservableList<String> types = FXCollections.observableArrayList("Земной тип", "Газовый гигант", "Ледяной гигант", "Карликовая планета");

    @FXML TextField tfName, tfRadius, tfWeight, tfAmount, tfDistance;
    @FXML TableView<Planet> tvMain;
    @FXML TableColumn<Planet, String> colName;
    @FXML TableColumn<Planet, String> colType;
    @FXML TableColumn<Planet, Double> colRad;
    @FXML TableColumn<Planet, Double> colWeight;
    @FXML TableColumn<Planet, Integer> colAmount;
    @FXML TableColumn<Planet, Double> colDistance;



    @FXML public ComboBox<String> cbType;

    @FXML
    protected void btnShow_Click(ActionEvent actionEvent) {
        if (planets.stream().count() <= 0) return;
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Bestie");
        info.setHeaderText("Who is ur Bestie?");
        Double maxRad = planets.get(0).getRadius(),
                maxWeight = planets.get(0).getWeight(),
                maxDistance = planets.get(0).getDistance();
        int maxAmount = planets.get(0).getAmount();
        String firstPlanet = planets.get(0).getName(),
                maxRadPlanet = firstPlanet, maxWeightPlanet = firstPlanet,
                maxDistancePlanet = firstPlanet, maxAmountPlanet = firstPlanet;
        for (int i = 1; i < planets.toArray().length; i++) {
            var planetNow = planets.get(i);
            if (planetNow.getRadius() > maxRad) {
                maxRad = planetNow.getRadius();
                maxRadPlanet = planetNow.getName();
            }
            if (planetNow.getWeight() > maxWeight) {
                maxWeight = planetNow.getWeight();
                maxWeightPlanet = planetNow.getName();
            }
            if (planetNow.getDistance() > maxDistance) {
                maxDistance = planetNow.getDistance();
                maxDistancePlanet = planetNow.getName();
            }
            if (planetNow.getAmount() > maxAmount) {
                maxAmount = planetNow.getAmount();
                maxAmountPlanet = planetNow.getName();
            }
        }

        String result = String.format("""
                Максимальный радиус у - %s (%.3f км)\
                
                Максимальная масса у - %s (%.3f масс земли)\
                
                Максимальное кол-во спутников у - %s (%d шт)\
                
                Максимальная удаленность от Земли у - %s (%.3f тыс. км)
                """, maxRadPlanet, maxRad, maxWeightPlanet, maxWeight, maxAmountPlanet, maxAmount, maxDistancePlanet, maxDistance);

        info.setContentText(result);
        info.show();
    }

    @FXML
    protected void SetColumns(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRad.setCellValueFactory(new PropertyValueFactory<>("radius"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @FXML
    protected void initialize(){
        cbType.setItems(types);
        Platform.runLater(() ->{
            SetColumns();
        });

    }

    @FXML
    protected void Add (ActionEvent actionEvent){
        if (!tfName.getText().isBlank() && !tfAmount.getText().isBlank() && !tfDistance.getText().isBlank() && !tfRadius.getText().isBlank() && !tfWeight.getText().isBlank()) {
            Planet newPlanet = null;
            switch (cbType.getValue()){
                case "Земной тип":
                    newPlanet = new EarthTypePlanet(tfName.getText(), Double.valueOf(tfRadius.getText()), Double.valueOf(tfWeight.getText()),
                            Integer.valueOf(tfAmount.getText()), Double.valueOf(tfDistance.getText()));
                    break;
                case "Газовый гигант":
                    newPlanet = new GasGiant(tfName.getText(), Double.valueOf(tfRadius.getText()), Double.valueOf(tfWeight.getText()),
                            Integer.valueOf(tfAmount.getText()), Double.valueOf(tfDistance.getText()));
                    break;
                case "Ледяной гигант":
                    newPlanet = new IceGiant(tfName.getText(), Double.valueOf(tfRadius.getText()), Double.valueOf(tfWeight.getText()),
                            Integer.valueOf(tfAmount.getText()), Double.valueOf(tfDistance.getText()));
                    break;
                case "Карликовая планета":
                    newPlanet = new DwarfPlanet(tfName.getText(), Double.valueOf(tfRadius.getText()), Double.valueOf(tfWeight.getText()),
                            Integer.valueOf(tfAmount.getText()), Double.valueOf(tfDistance.getText()));
                    break;
            }
            if (newPlanet == null) return;
            planets.add(newPlanet);
            tvMain.setItems(planets);

            tfAmount.clear();
            tfDistance.clear();
            tfName.clear();
            tfWeight.clear();
            tfRadius.clear();
        }
    }
    @FXML
    protected void Delete (ActionEvent actionEvent) {
        ObservableList<Planet> selectedItems = tvMain.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()){
            planets.remove(selectedItems);
            tvMain.getItems().clear();
            tvMain.setItems(planets);
        }
    }
}
