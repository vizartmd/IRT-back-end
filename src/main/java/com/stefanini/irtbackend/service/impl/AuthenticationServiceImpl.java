package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.security.jwt.JwtTokenProvider;
import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.AuthenticationService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.function.DoubleToIntFunction;

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
    public UserDto authenticate(AuthenticationRequestDTO request) {
        System.out.println("AuthenticationRequestDTO: " + request.toString());
        System.out.println("userName: " + request.getUsername());
        User user = userService.findByUsername(request.getUsername());
        System.out.println("user: " + user);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtTokenProvider.createToken(request.getUsername(), user.getRole().name());
        UserDto userDto = UserDto.from(user);
        userDto.setAccessToken(token);
        return userDto;
    }
}
