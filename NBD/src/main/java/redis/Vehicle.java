package redis;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbSubtype;
import jakarta.json.bind.annotation.JsonbTypeInfo;

@JsonbTypeInfo({
        @JsonbSubtype(alias = "motorcycle", type = Motorcycle.class),
        @JsonbSubtype(alias = "bicycle", type = Bicycle.class),
        @JsonbSubtype(alias = "car", type = Car.class),
})
abstract public class Vehicle {
    @JsonbProperty("_id")
    private final String id;
    @JsonbProperty("weight")
    private final int weight;
    @JsonbProperty("color")
    private final String color;
    @JsonbProperty("price")
    private final double price;
    @JsonbProperty("rented")
    private final int rented;

    @JsonbCreator
    public Vehicle(@JsonbProperty("_id") String id,
                   @JsonbProperty("weight") int weight,
                   @JsonbProperty("color") String color,
                   @JsonbProperty("price") double price,
                   @JsonbProperty("rented") int rented) {
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
