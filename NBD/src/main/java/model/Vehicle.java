package model;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator(key = "_clazz")
public abstract class Vehicle {
    @BsonProperty("_id")
    private final String id;
    @BsonProperty("weight")
    private final int weight;
    @BsonProperty("color")
    private final String color;
    @BsonProperty("price")
    private final double price;
    @BsonProperty("rented")
    private final int rented;


    public Vehicle(@BsonProperty("_id") String id,
                   @BsonProperty("weight") int weight,
                   @BsonProperty("color") String color,
                   @BsonProperty("price") double price,
                   @BsonProperty("rented") int rented) {
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
