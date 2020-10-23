package com.captians.slangdictionary.model;

import com.captians.slangdictionary.validation.EmptyOrSize;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EmptyOrSize(message = "{user.firstName.emptyOrSize}")
    @Column(name = "first_name")
    private String firstName;

    @EmptyOrSize(message = "{user.lastName.emptyOrSize}")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "{user.email}")
    @NotEmpty(message = "{user.email.empty}")
    @Column(unique = true)
    private String email;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address singleAddress;

    @Valid
    @OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "USER")
    private UserCredentials userCredentials = new UserCredentials();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Term> terms = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userCredentials.getAuthority().stream().map(x -> new SimpleGrantedAuthority(x.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userCredentials.getPassword();
    }

    @Override
    public String getUsername() {
        return userCredentials.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userCredentials.getEnabled();
    }
}
