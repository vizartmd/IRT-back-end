package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.entity.JwtToken;
import com.stefanini.irtbackend.service.JwtTokenService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtTokenController {

    private final JwtTokenService jwtTokenService;

    public JwtTokenController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/token/{counter}")
    JwtToken create(@PathVariable String counter) {
        System.out.println("In create token: " + counter);
        JwtToken jwtToken = new JwtToken(Long.parseLong(counter));
        System.out.println("jwtToken: " + jwtToken.toString());
        JwtToken createdJwtToken = jwtTokenService.create(jwtToken);
        System.out.println("createdJwtToken: " + createdJwtToken.toString());
        return createdJwtToken;
    }

}
