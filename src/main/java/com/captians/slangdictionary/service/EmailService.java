package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.EmailConfirmationToken;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    void save(EmailConfirmationToken emailConfirmationToken);

    @Async
    void sendEmail(SimpleMailMessage email);

    EmailConfirmationToken findByConfirmationToken(String confirmationToken);
}
