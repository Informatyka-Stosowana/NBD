package model;

abstract public class Vehicle {
    private final String id;
    private final int weight;
    private final String color;
    private final double price;
    private final int rented;

    public Vehicle(String id,
                   int weight,
                   String color,
                   double price,
                   int rented) {
        this.id = id;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.rented = rented;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int isRented() {
        return rented;
    }
}
