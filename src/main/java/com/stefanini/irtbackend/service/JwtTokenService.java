package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.entity.JwtToken;

import java.util.List;

public interface JwtTokenService {
    JwtToken create(JwtToken jwtToken);

    List<JwtToken> findAll();
}
