package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.GenerateSecurePassword;
import com.stefanini.irtbackend.domain.entity.Response;
import com.stefanini.irtbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    GenerateSecurePassword generateSecurePassword;

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public Response sendResetPasswordEmail(String email, String password) {
        Response response = new Response();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password reset !");

            message.setText("This is your temporary password. Please update it after sign into your account ! " + "\r\n" + "Temporary password : " + password);

            emailSender.send(message);

            response.setCode(0);
            response.setMessage("Email send ok!");
        } catch (Exception ex) {
            response.setCode(1);
            response.setMessage("Error sending email:" + ex.getMessage());
        }

        return response;
    }
}
