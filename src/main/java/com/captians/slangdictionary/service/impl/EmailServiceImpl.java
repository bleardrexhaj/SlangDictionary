package com.captians.slangdictionary.service.impl;

import com.captians.slangdictionary.dao.ConfirmationTokenDao;
import com.captians.slangdictionary.model.EmailConfirmationToken;
import com.captians.slangdictionary.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    private ConfirmationTokenDao confirmationTokenDao;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    @Override
    public EmailConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenDao.findByConfirmationToken(confirmationToken);
    }

    @Override
    public void save(EmailConfirmationToken emailConfirmationToken) {
        confirmationTokenDao.save(emailConfirmationToken);
    }
}
