package model;

public class Motorcycle extends Vehicle {
    private int engineDisplacement;

    public Motorcycle(int id, int weight, String color, double price, int engineDisplacement) {
        super(id, weight, color, price);
        this.engineDisplacement = engineDisplacement;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }
}
