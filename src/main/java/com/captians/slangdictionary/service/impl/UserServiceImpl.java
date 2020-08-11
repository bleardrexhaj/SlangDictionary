package com.captians.slangdictionary.service.impl;

import com.captians.slangdictionary.dao.UserDao;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
