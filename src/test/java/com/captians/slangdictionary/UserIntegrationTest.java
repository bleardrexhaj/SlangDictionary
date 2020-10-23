package com.captians.slangdictionary;

import com.captians.slangdictionary.model.Address;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.model.UserCredentials;
import com.captians.slangdictionary.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerUser() throws Exception {
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

        user.setSingleAddress(address);
        userService.save(user);

        User findUser = userService.findUserByEmail(user.getEmail());
        assertThat(user.getFirstName()).isEqualTo(findUser.getFirstName());
    }

    @WithMockUser(username = "bleard", password = "admin", authorities = {"USER"})
    @Test
    public void withMockUser() throws Exception {
        //protected path testing
        this.mockMvc.perform(get("/myterms")).andExpect(status().isOk());
    }
}
