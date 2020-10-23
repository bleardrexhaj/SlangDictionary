package com.captians.slangdictionary.aspect;

import com.captians.slangdictionary.model.*;
import com.captians.slangdictionary.service.EmailService;
import com.captians.slangdictionary.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Aspect
@Component
public class UserAspect {

    private final EmailService emailService;
    private final UserService userService;

    @Autowired
    public UserAspect(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @Pointcut("execution(* com.captians.slangdictionary.service.UserService.save(..))")
    public void addAddress(){
    }

    @Pointcut("args(user)")
    public void addArgs(User user){
    }

    @Before("addAddress() && addArgs(user)")
    public void beforeExecution(JoinPoint joinPoint, User user){

        //Validate user`s existence
        if(userService.findUserByEmail(user.getEmail()) != null ) throw new DataIntegrityViolationException("Email already exists");
        else if(userService.findUserByUserName(user.getUserCredentials().getUsername()) != null) throw new DataIntegrityViolationException("Username already exists");

        //Encrypting Password.
        UserCredentials userCredentials = user.getUserCredentials();
        userCredentials.setEnabled(false);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userCredentials.setPassword(bCryptPasswordEncoder.encode(user.getUserCredentials().getPassword()));
        userCredentials.setVerifyPassword(userCredentials.getPassword());

        //Assign Roles
        ArrayList<Authorities> roles = new ArrayList<>();
        Authorities authorities = new Authorities();
        authorities.setAuthority("USER");
        roles.add(authorities);

        //Assigning relationships
        userCredentials.setAuthority(roles);
        userCredentials.setUser(user);
    }

    @After("addAddress() && addArgs(user)")
    public void afterExecution(JoinPoint joinPoint, User user){
        EmailConfirmationToken confirmationToken = new EmailConfirmationToken(user);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("{spring.mail.username}"); // TODO test this
        mailMessage.setText("To confirm your account, please click here : "+"http://albslang.com/confirm-account?token="+confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);
        emailService.save(confirmationToken);
    }
}
