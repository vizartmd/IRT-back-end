package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;

public interface AuthenticationService {

    public String authenticate(AuthenticationRequestDTO request);
}
