package com.captians.slangdictionary.model;


import com.captians.slangdictionary.validation.FieldMatch;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Authentication")
@FieldMatch(first = "password", second = "verifyPassword", message = "{User.password}")
public class UserCredentials {

    @Id
    @Column(name = "USER", nullable = false, unique = true, length = 127)
    private String userName;

    @NotEmpty(message = "{Password.NotEmpty}")
    @Size(min = 6, max = 60,message = "{Password.Size}")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Transient
    private String verifyPassword;

    @Column(columnDefinition = "boolean DEFAULT false")
    private Boolean enabled;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "userCredentials")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private List<Authority> authority = new ArrayList<Authority>();

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

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
}
