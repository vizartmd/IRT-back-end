package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.service.UserService;
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
    private UserService userService;

    @PostMapping("/{email}/emails/reset-password")
    public ResponseEntity<Void> sendEmail(@PathVariable("email") String email) {
        userService.resetPasswordFor(email);
        return ResponseEntity.ok().build();

    }
}
