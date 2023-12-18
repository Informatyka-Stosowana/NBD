package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

@Entity(defaultKeyspace = "rent_a_vehicle")
@CqlName("vehicles")
abstract public class Vehicle {
    @PartitionKey
    @CqlName("id")
    private final String id;
    @CqlName("weight")
    private final int weight;
    @CqlName("color")
    private final String color;
    @CqlName("price")
    private final double price;
    @CqlName("rented")
    private final int rented;
    @CqlName("discriminator")
    private final String discriminator;

    public Vehicle(String id,
                   int weight,
                   String color,
                   double price,
                   int rented,
                   String discriminator) {
        this.id = id;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.rented = rented;
        this.discriminator = discriminator;
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
