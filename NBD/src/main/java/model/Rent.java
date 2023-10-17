package model;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Rent {
    @Id
    private int id;
    private double price;
    private boolean archive = false;
    @OneToOne
    private Client client;
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
