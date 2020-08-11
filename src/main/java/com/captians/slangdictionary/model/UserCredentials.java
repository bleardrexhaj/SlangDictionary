package com.captians.slangdictionary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Authentication")
public class UserCredentials {

    @Id
    @Column(name = "USER", nullable = false, unique = true, length = 127)
    String userName;
    @Column(name = "PASSWORD", nullable = false)
    String password;

    @Transient
    String verifyPassword;

    @Column(columnDefinition = "boolean DEFAULT false")
    Boolean enabled;

    @OneToOne(mappedBy = "userCredentials", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    List<Authority> authority = new ArrayList<Authority>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
