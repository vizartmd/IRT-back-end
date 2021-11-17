package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.service.EmailService;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendResetPasswordEmail(String email, String password) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password reset !");

            message.setText("This is your temporary password. Please update it after sign into your account ! " + "\r\n" + "Temporary password : " + password);

            emailSender.send(message);
        } catch (Exception ex) {
            throw new MailSendException(ex.getMessage());
        }
    }
}
