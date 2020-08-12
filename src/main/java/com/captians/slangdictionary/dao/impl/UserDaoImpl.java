package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.UserDao;
import com.captians.slangdictionary.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

    public UserDaoImpl(){
        super.setDaoType(User.class);
    }

    @Override
    public void save(User user) {
        super.save(user);
    }

    @Override
    public void update(User user) {
        super.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        Query query = persistence.createQuery("select u from User u where u.email =:email");
        return (User) query.setParameter("email", email).getSingleResult();
    }
}
