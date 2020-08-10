package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.UserDao;
import com.captians.slangdictionary.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
}
