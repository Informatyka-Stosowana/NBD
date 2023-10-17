package model;

import com.sun.istack.NotNull;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("motorcycle")
public class Motorcycle extends Vehicle {
    @NotNull
    private int engineDisplacement;

    public Motorcycle(int id, int weight, String color, double price, int engineDisplacement) {
        super(id, weight, color, price);
        this.engineDisplacement = engineDisplacement;
    }

    public Motorcycle() {}

    public int getEngineDisplacement() {
        return engineDisplacement;
    }
}
