package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

public class ClientAddress {
    @CqlName("street")
    final String street;
    @CqlName("streetNumber")
    private final int streetNumber;
    @CqlName("city")
    private final String city;
    @CqlName("postcode")
    private final int postcode;
    @CqlName("firstName")
    private final String firstName;
    @PartitionKey
    @CqlName("id")
    private final int personalId;
    @CqlName("lastName")
    private final String lastName;
    @CqlName("noRents")
    private final int noRents;


    public ClientAddress(int personalId,
                         String firstName,
                         String lastName,
                         int noRents,
                         String street,
                         int streetNumber,
                         String city,
                         int postcode) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noRents = noRents;
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
