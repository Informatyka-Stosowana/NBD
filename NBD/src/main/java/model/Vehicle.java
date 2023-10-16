package model;

public abstract class Vehicle {
    private int id;
    private int weight;
    private String color;
    private double price;
    private boolean isRented;

    public Vehicle(int id, int weight, String color, double price) {
        this.id = id;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.isRented = false;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
