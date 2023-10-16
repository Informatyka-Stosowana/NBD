package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int personalId;
    private Address address;
    private String firstName;
    private String lastName;
    private ArrayList<Rent> currentRents = new ArrayList<>();

    public Client(int personalId, Address address, String firstName, String lastName) {
        this.personalId = personalId;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
