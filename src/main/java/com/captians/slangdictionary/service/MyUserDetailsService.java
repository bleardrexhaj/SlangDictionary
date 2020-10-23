package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.UserCredentials;

public interface MyUserDetailsService {
    public UserCredentials findUserByUserName(String name);
}
