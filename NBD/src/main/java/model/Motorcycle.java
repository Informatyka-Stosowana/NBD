package model;

public class Motorcycle extends Vehicle {
    private final int engineDisplacement;

    public Motorcycle(String id,
                      int weight,
                      String color,
                      double price,
                      int engineDisplacement,
                      int rented) {
        super(id, weight, color, price, rented);
        this.engineDisplacement = engineDisplacement;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }
}
