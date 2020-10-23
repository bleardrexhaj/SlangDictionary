package com.captians.slangdictionary.service.impl;


import com.captians.slangdictionary.model.UserCredentials;
import com.captians.slangdictionary.service.MyUserDetailsService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserCredentials findUserByUserName(String name) {
        return userService.findUserByUserName(name).getUserCredentials();
    }
}
