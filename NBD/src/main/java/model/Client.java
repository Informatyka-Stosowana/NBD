package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class Client {
    @Id
    private int personalId;
    private Address address;
    private String firstName;
    private String lastName;
    @OneToMany
    private ArrayList<Rent> currentRents = new ArrayList<>();

    public Client(int personalId, Address address, String firstName, String lastName) {
        this.personalId = personalId;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client() {}

    public int getPersonalId() {
        return personalId;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addRent(Rent rent) {
        currentRents.add(rent);
    }
    public void deleteRent(Rent rent) {
        currentRents.remove(rent);
    }

    public ArrayList<Rent> getCurrentRents() {
        return currentRents;
    }
}
