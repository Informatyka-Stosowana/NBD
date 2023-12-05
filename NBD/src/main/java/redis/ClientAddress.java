package redis;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class ClientAddress {
    @JsonbProperty("_id")
    private final int personalId;
    @JsonbProperty("firstName")
    private final String firstName;
    @JsonbProperty("lastname")
    private final String lastName;
    @JsonbProperty("noRents")
    private final int noRents;
    @JsonbProperty("street")
    private final String street;
    @JsonbProperty("streetNumber")
    private final int streetNumber;
    @JsonbProperty("city")
    private final String city;
    @JsonbProperty("postcode")
    private final int postcode;

    @JsonbCreator
    public ClientAddress(@JsonbProperty("_id") int personalId,
                         @JsonbProperty("firstName") String firstName,
                         @JsonbProperty("lastname") String lastName,
                         @JsonbProperty("noRents") int noRents,
                         @JsonbProperty("street") String street,
                         @JsonbProperty("streetNumber") int streetNumber,
                         @JsonbProperty("city") String city,
                         @JsonbProperty("postcode") int postcode) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noRents = noRents;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public ClientAddress(int personalId,
                         String firstName,
                         String lastName,
                         String street,
                         int streetNumber,
                         String city,
                         int postcode) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noRents = 0;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public int getNoRents() {
        return noRents;
    }

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

    public int getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
