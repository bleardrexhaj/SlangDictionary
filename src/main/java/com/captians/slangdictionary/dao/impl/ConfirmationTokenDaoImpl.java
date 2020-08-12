package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.ConfirmationTokenDao;
import com.captians.slangdictionary.model.EmailConfirmationToken;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class ConfirmationTokenDaoImpl extends GenericDaoImpl<EmailConfirmationToken> implements ConfirmationTokenDao {

    public ConfirmationTokenDaoImpl(){
        super.setDaoType(EmailConfirmationToken.class);
    }

    @Override
    public EmailConfirmationToken findByConfirmationToken(String confirmationToken) {
        Query query = super.persistence.createQuery("select c from confirmation_token c where c.confirmationToken=:confirmationToken");
        return  (EmailConfirmationToken) query.setParameter("confirmationToken", confirmationToken).getSingleResult();
    }

    @Override
    public void save(EmailConfirmationToken emailConfirmationToken) {
        super.save(emailConfirmationToken);
    }
}
