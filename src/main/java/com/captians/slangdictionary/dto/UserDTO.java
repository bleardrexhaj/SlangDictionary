package com.captians.slangdictionary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String street, city, country, zipCode;

    private String username, password, verifyPassword;
}
