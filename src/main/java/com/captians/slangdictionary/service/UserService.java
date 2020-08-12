package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.User;

public interface UserService {
    void save(User user);
    void update(User user);
    User findUserByEmail(String email);
}
