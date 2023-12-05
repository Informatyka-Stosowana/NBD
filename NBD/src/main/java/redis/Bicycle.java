package redis;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Bicycle extends Vehicle {
    @JsonbProperty("helperwheels")
    private final boolean helperWheels;

    @JsonbCreator
    public Bicycle(@JsonbProperty("_id") String id,
                   @JsonbProperty("weight") int weight,
                   @JsonbProperty("color") String color,
                   @JsonbProperty("price") double price,
                   @JsonbProperty("helperwheels") boolean helperWheels,
                   @JsonbProperty("rented") int rented) {
        super(id, weight, color, price, rented);
        this.helperWheels = helperWheels;
    }

    public boolean isHelperWheels() {
        return helperWheels;
    }
}
