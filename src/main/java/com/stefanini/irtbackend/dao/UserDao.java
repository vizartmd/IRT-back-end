package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.entity.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String userName);
}
