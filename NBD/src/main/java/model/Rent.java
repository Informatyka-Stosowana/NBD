package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

@Entity(defaultKeyspace = "rent_a_vehicle")
public class Rent {
    private ClientAddress client;
    private Vehicle vehicle;
    @PartitionKey
    @CqlName("id")
    private int id;
    @CqlName("archive")
    private boolean archive;

    public Rent(int id, ClientAddress client, Vehicle vehicle) {
        this.id = id;
        this.archive = false;
        this.client = client;
        this.vehicle = vehicle;
    }

    public Rent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientAddress getClient() {
        return client;
    }

    public void setClient(ClientAddress client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}
