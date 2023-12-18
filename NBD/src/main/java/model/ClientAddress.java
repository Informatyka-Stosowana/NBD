package model;

public class ClientAddress {
    final String street;
    private final int streetNumber;

    private final String city;

    private final int postcode;
    private final String firstName;
    private final int personalId;
    private final String lastName;
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
