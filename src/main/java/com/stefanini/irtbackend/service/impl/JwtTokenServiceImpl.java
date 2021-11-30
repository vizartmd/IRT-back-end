package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.JwtTokenDao;
import com.stefanini.irtbackend.domain.entity.JwtToken;
import com.stefanini.irtbackend.service.JwtTokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtTokenDao jwtTokenDao;

    public JwtTokenServiceImpl(JwtTokenDao jwtTokenDao) {
        this.jwtTokenDao = jwtTokenDao;
    }

    @Override
    public JwtToken create(JwtToken jwtToken) {
        return jwtTokenDao.create(jwtToken);
    }

    @Override
    public List<JwtToken> findAll() {
        return jwtTokenDao.findAll();
    }
}
