package com.example.javafx_y3lec3pr3;

import javafx.beans.property.*;

public abstract class Planet{
    private SimpleStringProperty name;
    protected SimpleStringProperty type;
    private SimpleDoubleProperty radius;
    private SimpleDoubleProperty weight;
    private SimpleIntegerProperty amount;
    private SimpleDoubleProperty distance;



    public Planet(String name,  double radius, double weight, int amount, double distance){
        this.name = new SimpleStringProperty(name);
        this.radius = new SimpleDoubleProperty(radius);
        this.weight = new SimpleDoubleProperty(weight);
        this.amount = new SimpleIntegerProperty(amount);
        this.distance = new SimpleDoubleProperty(distance);
    }

    public String getName() {
        return name.get();
    }
    public String getType() {
        return type.get();
    }
    public Double getRadius() {
        return radius.get();
    }
    public Double getWeight() {
        return weight.get();
    }
    public Integer getAmount() {
        return amount.get();
    }
    public Double getDistance() {
        return distance.get();
    }

}
class EarthTypePlanet extends Planet {
    public EarthTypePlanet(String name, double radius, double weight, int amount, double distance){
        super(name, radius, weight, amount, distance);
        this.type = new SimpleStringProperty("Земной тип");
    }
}
class GasGiant extends Planet {
    public GasGiant(String name, double radius, double weight, int amount, double distance){
        super(name, radius, weight, amount, distance);
        this.type = new SimpleStringProperty("Газовый гигант");
    }
}
class IceGiant extends Planet {
    public IceGiant(String name, double radius, double weight, int amount, double distance){
        super(name, radius, weight, amount, distance);
        this.type = new SimpleStringProperty("Ледяной гигант");
    }
}
class DwarfPlanet extends Planet {
    public DwarfPlanet(String name, double radius, double weight, int amount, double distance){
        super(name, radius, weight, amount, distance);
        this.type = new SimpleStringProperty("Карликовая планета");
    }
}

