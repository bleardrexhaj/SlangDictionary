package com.captians.slangdictionary.test;

import com.captians.slangdictionary.model.Address;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.model.UserCredentials;
import com.captians.slangdictionary.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIntegrationTest {
    @Autowired
    UserService userService;

    @Test
    public void registerUser(){
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("slangdictionaryproject@gmail.com");

        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword("JohnDoe");
        user.setUserCredentials(userCredentials);

        Address address = new Address();
        address.setCity("Bronx");
        address.setCountry("New York");
        address.setStreet("1th st");
        address.setZipCode("10460");

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);

        user.setAddress(addresses);

        userService.save(user);

        User findUser = userService.findUserByEmail(user.getEmail());
        assertThat(user.getFirstName()).isEqualTo(findUser.getFirstName());
    }
}
