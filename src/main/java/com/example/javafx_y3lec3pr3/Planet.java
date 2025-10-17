package com.example.javafx_y3lec3pr3;

abstract class Planet{
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
class EarthTypePlanet extends Planet {
    public EarthTypePlanet(String name, double radius, double weight, double amount, double distance){
        super(name, radius, weight, amount, distance);
        this._type = "Земной тип";
    }
}
class GasGiant extends Planet {
    public GasGiant(String name, double radius, double weight, double amount, double distance){
        super(name, radius, weight, amount, distance);
        this._type = "Газовый гигант";
    }
}
class IceGiant extends Planet {
    public IceGiant(String name, double radius, double weight, double amount, double distance){
        super(name, radius, weight, amount, distance);
        this._type = "Ледяной гигант";
    }
}
class DwarfPlanets extends Planet {
    public DwarfPlanets(String name, double radius, double weight, double amount, double distance){
        super(name, radius, weight, amount, distance);
        this._type = "Карликовая планета";
    }
}

