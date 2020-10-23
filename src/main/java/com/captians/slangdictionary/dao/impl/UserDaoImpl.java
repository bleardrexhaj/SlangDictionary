package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.UserDao;
import com.captians.slangdictionary.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

    public UserDaoImpl(){
        super.setDaoType(User.class);
    }

    @Override
    public void save(User user){
        super.save(user);
    }

    @Override
    public void update(User user) {
        super.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        Query query = persistence.createQuery("select u from User u where u.email =:email");
        User user  = null;
        try {
            user = (User) query.setParameter("email", email).getSingleResult();
        } catch (NoResultException ignored){ }

        return user;
    }

    @Override
    public User findUserByUserName(String userName) {
        Query query = persistence.createQuery("select u from User u where u.userCredentials.username =:userName");

        User user  = null;
        try {
            user = (User) query.setParameter("userName", userName).getSingleResult();
        } catch (NoResultException ignored){ }

        return user;
    }
}
