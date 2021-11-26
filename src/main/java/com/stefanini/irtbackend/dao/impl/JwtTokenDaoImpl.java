package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.JwtTokenDao;
import com.stefanini.irtbackend.domain.entity.JwtToken;
import com.stefanini.irtbackend.domain.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class JwtTokenDaoImpl extends GenericDaoImpl<JwtToken> implements JwtTokenDao {

    public JwtTokenDaoImpl() {
        super(JwtToken.class);
    }
}
