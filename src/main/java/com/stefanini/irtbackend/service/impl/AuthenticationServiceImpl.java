package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.security.jwt.JwtTokenProvider;
import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.AuthenticationService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    @Transactional
    public String authenticate(AuthenticationRequestDTO request) {
        User user = userService.findByUsername(request.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return jwtTokenProvider.createToken(request.getUsername(), user.getRole().name());
    }
}
