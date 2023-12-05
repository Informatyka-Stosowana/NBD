package redis;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;


public class Motorcycle extends Vehicle {
    @JsonbProperty("engineDisplacement")
    private final int engineDisplacement;

    @JsonbCreator
    public Motorcycle(@JsonbProperty("_id") String id,
                      @JsonbProperty("weight") int weight,
                      @JsonbProperty("color") String color,
                      @JsonbProperty("price") double price,
                      @JsonbProperty("engineDisplacement") int engineDisplacement,
                      @JsonbProperty("rented") int rented) {
        super(id, weight, color, price, rented);
        this.engineDisplacement = engineDisplacement;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }
}
