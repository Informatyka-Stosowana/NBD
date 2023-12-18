package model;

public class Bicycle extends Vehicle {

    private final boolean helperWheels;


    public Bicycle(String id,
                   int weight,
                   String color,
                   double price,
                   boolean helperWheels,
                   int rented) {
        super(id, weight, color, price, rented);
        this.helperWheels = helperWheels;
    }

    public boolean isHelperWheels() {
        return helperWheels;
    }
}
