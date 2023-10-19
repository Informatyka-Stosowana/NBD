package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class Client {
    @Id
    private int personalId;
    @NotNull
    private Address address;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @OneToMany
    private List<Rent> currentRents = new ArrayList<>();

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
    public void removeRent(int rentId) {
        for (int i = 0; i < currentRents.size(); i++) {
            if (currentRents.get(i).getId() == rentId) currentRents.remove(i);
        }
    }

    public List<Rent> getCurrentRents() {
        return currentRents;
    }
}
