package com.captians.slangdictionary.model;

import com.captians.slangdictionary.validation.EmptyOrSize;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @EmptyOrSize(message = "{User.name}")
    @Column(name = "first_name")
    private String firstName;

    @EmptyOrSize(message = "{User.name}")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "{User.email}")
    @NotEmpty(message = "{User.email.Empty}")
    @Column(unique = true)
    private String email;

    @Transient
    @Valid
    private Address singleAddress;

    @Valid
    @OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserCredentials userCredentials = new UserCredentials();

    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Address> address = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Term> terms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public Address getSingleAddress() {
        return singleAddress;
    }

    public void setSingleAddress(Address singleAddress) {
        this.singleAddress = singleAddress;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Set<Term> getTerms() {
        return terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms = terms;
    }
}
