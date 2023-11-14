package model;

import ch.qos.logback.core.net.server.Client;

public class Rent {
    private int id;
    private double price;
    private boolean archive;
    private Client client;
    private Vehicle vehicle;

    public Rent(int id, Client client, Vehicle vehicle) {
        this.id = id;
        this.price = vehicle.getPrice();
        this.archive = false;
        this.client = client;
        this.vehicle = vehicle;
    }

    public Rent() {
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

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}
