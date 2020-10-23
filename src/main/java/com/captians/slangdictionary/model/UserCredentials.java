package com.captians.slangdictionary.model;


import com.captians.slangdictionary.validation.FieldMatch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity(name = "authentication")
@FieldMatch(first = "password", second = "verifyPassword", message = "{User.password}")
public class UserCredentials {

    @Id
    @Column(name = "USER", nullable = false, unique = true, length = 127)
    private String username;

    @NotEmpty(message = "{Password.NotEmpty}")
    @Size(min = 6, max = 60,message = "{Password.Size}")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Transient
    private String verifyPassword;

    @Column(columnDefinition = "boolean DEFAULT false")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "authentication_id")
    private List<Authorities> authority;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "userCredentials")
    private User user;
}
