package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    public Optional<User> selectUserByUsername(String username);
}
