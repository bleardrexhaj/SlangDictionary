package com.captians.slangdictionary.aspect;

import com.captians.slangdictionary.model.Address;
import com.captians.slangdictionary.model.Authority;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.model.UserCredentials;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class UserAspect {
    @Pointcut("execution(* com.captians.slangdictionary.service.UserService.*(..))")
    public void addAddress(){
    }

    @Pointcut("args(user)")
    public void addArgs(User user){
    }


    @Before("addAddress() && addArgs(user)")
    public void beforeExecution(JoinPoint joinPoint, User user){
        //Assigning the address to the user.
        Set<Address> addresses = new HashSet<>();
        addresses.add(user.getSingleAddress());
        user.setAddress(addresses);

        //Adding a Role User to user by default.
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEnabled(true);
        userCredentials.setUserName(user.getFirstName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userCredentials.setPassword(bCryptPasswordEncoder.encode(user.getUserCredentials().getPassword()));
        userCredentials.setVerifyPassword(userCredentials.getPassword());

        //Setting up Roles for this specific user.
        List<Authority> authorityList = new ArrayList<>();
        Authority authority = new Authority();
        authority.setAuthority("User");
        authority.setUsername(user.getFirstName());
        authorityList.add(authority);

        //Assigning relationships
        userCredentials.setAuthority(authorityList);
        userCredentials.setUser(user);
        user.setUserCredentials(userCredentials);
    }
}
