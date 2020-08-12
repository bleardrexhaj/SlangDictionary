package com.captians.slangdictionary.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "{User.address}")
    private String street;

    @NotEmpty(message = "{User.address}")
    private String city;

    @NotEmpty(message = "{User.address}")
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
