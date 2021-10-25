package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;
import com.stefanini.irtbackend.domain.dto.UserDto;

public interface AuthenticationService {

    public UserDto authenticate(AuthenticationRequestDTO request);
}
