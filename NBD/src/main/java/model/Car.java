package model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("car")
public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(int id, int weight, String color, double price, int numberOfSeats) {
        super(id, weight, color, price);
        this.numberOfSeats = numberOfSeats;
    }

    public Car() {}

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
