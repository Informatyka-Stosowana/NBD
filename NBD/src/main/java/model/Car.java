package model;

public class Car extends Vehicle {

    private final int numberOfSeats;


    public Car(String id,
               int weight,
               String color,
               double price,
               int rented,
               int numberOfSeats) {
        super(id, weight, color, price, rented);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
