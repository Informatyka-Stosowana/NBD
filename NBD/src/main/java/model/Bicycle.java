package model;

public class Bicycle extends Vehicle {
    private boolean helperWheels;

    public Bicycle(int id, int weight, String color, double price, boolean helperWheels) {
        super(id, weight, color, price);
        this.helperWheels = helperWheels;
    }

    public Bicycle() {}

    public boolean isHelperWheels() {
        return helperWheels;
    }
}
