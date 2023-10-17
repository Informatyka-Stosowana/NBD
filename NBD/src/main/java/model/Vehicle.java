package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Vehicle {
    @Id
    private int id;
    @NotNull
    private int weight;
    @NotNull
    private String color;
    @NotNull
    private double price;
    @NotNull
    private boolean isRented;


    public Vehicle(int id, int weight, String color, double price) {
        this.id = id;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.isRented = false;
    }

    public Vehicle() {}

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
