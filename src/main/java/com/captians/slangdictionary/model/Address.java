package com.captians.slangdictionary.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{address.street.notEmpty}")
    private String street;

    @NotEmpty(message = "{address.city.notEmpty}")
    private String city;

    @NotEmpty(message = "{address.country.notEmpty}")
    private String country;

    @NotNull
    @Size(min = 5, max = 9, message = "{User.address.zip}")
    @Column(name = "zip_code")
    private String zipCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
