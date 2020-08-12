package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.EmailConfirmationToken;

public interface ConfirmationTokenDao {
    EmailConfirmationToken findByConfirmationToken(String confirmationToken);
    void save(EmailConfirmationToken emailConfirmationToken);
}
