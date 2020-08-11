package com.captians.slangdictionary.model;

import com.captians.slangdictionary.validation.EmptyOrSize;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    private String email;

    @Valid
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Address> address;

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

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
