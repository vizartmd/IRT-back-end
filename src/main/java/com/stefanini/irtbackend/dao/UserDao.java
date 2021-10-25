package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.entity.User;

public interface UserDao extends GenericDao<User> {
    User findByEmail(String email);

    User findByUsername(String userName);
}