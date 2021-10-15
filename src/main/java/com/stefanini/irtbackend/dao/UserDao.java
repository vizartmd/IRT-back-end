package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.entity.User;

public interface UserDao extends GenericDao<User> {
    User findByUserName(String userName);
    User findByEmail(String email);
}