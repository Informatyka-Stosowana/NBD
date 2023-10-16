package model;

public class Address {
    private String street;
    private int streetNumber;
    private String city;
    private int postcode;

    public Address(String street, int streetNumber, String city, int postcode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postcode = postcode;
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
}
