package redis;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;


public class Car extends Vehicle {
    @JsonbProperty("numberOfSeats")
    private final int numberOfSeats;

    @JsonbCreator
    public Car(@JsonbProperty("_id") String id,
               @JsonbProperty("weight") int weight,
               @JsonbProperty("color") String color,
               @JsonbProperty("price") double price,
               @JsonbProperty("rented") int rented,
               @JsonbProperty("numberOfSeats") int numberOfSeats) {
        super(id, weight, color, price, rented);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
