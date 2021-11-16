package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.entity.Response;
import com.stefanini.irtbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class EmailController {

    @Autowired
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/{email}/emails/reset-password")
    public ResponseEntity<Response> sendEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(emailService.sendEmail(email));

    }
}
