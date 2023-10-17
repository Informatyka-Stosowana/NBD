package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

@Entity
@Access(AccessType.FIELD)
public class Rent {
    @Id
    private int id;
    @NotNull
    private double price;
    @NotNull
    private boolean archive = false;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Client client; // do sprawdzenia
    @NotNull
    @OneToOne
    private Vehicle vehicle;

    public Rent(int id, Client client, Vehicle vehicle) {
        this.id = id;
        this.price = vehicle.getPrice();
        this.client = client;
        this.vehicle = vehicle;
    }

    public Rent() {}

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}
