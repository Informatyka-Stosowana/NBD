package model;

import com.sun.istack.NotNull;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("bicycle")
public class Bicycle extends Vehicle {
    @NotNull
    private boolean helperWheels;

    public Bicycle(int id, int weight, String color, double price, boolean helperWheels) {
        super(id, weight, color, price);
        this.helperWheels = helperWheels;
    }

    public Bicycle() {}

    public boolean isHelperWheels() {
        return helperWheels;
    }
}
