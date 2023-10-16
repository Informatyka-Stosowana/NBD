package model;

import java.util.Date;

public class Rent {
    private int id;
    private double price;
    private Client client;
    private Vehicle vehicle;

    public Rent(int id, Client client, Vehicle vehicle) {
        this.id = id;
        this.price = vehicle.getPrice();
        this.client = client;
        this.vehicle = vehicle;
    }

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
}
