package com.captians.slangdictionary.aspect;

import com.captians.slangdictionary.model.*;
import com.captians.slangdictionary.service.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class UserAspect {

    @Autowired
    EmailService emailService;

    @Pointcut("execution(* com.captians.slangdictionary.service.UserService.save(..))")
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
        userCredentials.setEnabled(false);
        userCredentials.setUserName(user.getFirstName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userCredentials.setPassword(bCryptPasswordEncoder.encode(user.getUserCredentials().getPassword()));
        userCredentials.setVerifyPassword(userCredentials.getPassword());

        //Setting up Roles for this specific user.
        List<Authority> authorityList = new ArrayList<>();
        Authority authority = new Authority();
        authority.setAuthority("USER");
        authority.setUsername(user.getFirstName());
        authorityList.add(authority);

        //Assigning relationships
        userCredentials.setAuthority(authorityList);
        userCredentials.setUser(user);
        user.setUserCredentials(userCredentials);
    }

    @After("addAddress() && addArgs(user)")
    public void afterExecution(JoinPoint joinPoint, User user){
        EmailConfirmationToken confirmationToken = new EmailConfirmationToken(user);

        emailService.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("{spring.mail.username}"); // TODO test this
        mailMessage.setText("To confirm your account, please click here : "+"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

        emailService.sendEmail(mailMessage);
    }
}
