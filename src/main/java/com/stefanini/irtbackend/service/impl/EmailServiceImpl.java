package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.domain.entity.Email;
import com.stefanini.irtbackend.domain.entity.Response;
import com.stefanini.irtbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public Response sendEmail(Email mail) {
        Response response = new Response();
        try {
            MimeMessage mm = new MimeMessage(session);

            mm.addRecipient(Message.RecipientType.TO, new InternetAddress("sandra.rusu17@gmail.com"));

            mm.setSubject("subject");

            mm.setText("message");


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("sandra.rusu17@gmail.com");
            message.setSubject("subject");
            message.setText("text");

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
