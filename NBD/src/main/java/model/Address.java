package model;

import com.sun.istack.NotNull;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
@Embeddable
@Access(AccessType.FIELD)
public class Address {
    // not empty
    private String street;
    @NotNull
    private int streetNumber;
    // not empty
    private String city;
    @NotNull
    private int postcode;

    public Address(String street, int streetNumber, String city, int postcode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public Address() {}

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public int getPostcode() {
        return postcode;
    }
}
