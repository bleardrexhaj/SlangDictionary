package com.captians.slangdictionary.aspect;

import com.captians.slangdictionary.model.Address;
import com.captians.slangdictionary.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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
        Set<Address> addresses = new HashSet<>();
        addresses.add(user.getSingleAddress());
        user.setAddress(addresses);
    }
}
