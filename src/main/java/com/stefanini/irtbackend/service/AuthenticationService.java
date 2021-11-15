package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.AuthenticationRequest;
import com.stefanini.irtbackend.domain.dto.UserDto;

public interface AuthenticationService {

    public UserDto authenticate(AuthenticationRequest request);
}
