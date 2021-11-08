package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.domain.entity.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);

    User findByEmail(String email);
}
