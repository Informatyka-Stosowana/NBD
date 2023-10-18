package model;

import com.sun.istack.NotNull;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
@Access(AccessType.FIELD)
public class Address {
    @NotEmpty
    private String street;
    @NotNull
    private int streetNumber;
    @NotEmpty
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
