package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.User;

public interface UserDao {
    void save(User user);
    void update(User user);
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
}
