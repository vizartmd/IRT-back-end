package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.entity.Email;
import com.stefanini.irtbackend.domain.entity.Response;
import com.stefanini.irtbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMailSimple")
    public ResponseEntity<Response> sendMailSimple(@RequestBody Email mail) {

        return ResponseEntity.ok(emailService.sendEmail(mail));
    }
}
