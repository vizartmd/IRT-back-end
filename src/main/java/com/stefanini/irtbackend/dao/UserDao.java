package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.domain.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllBySpecialty(String specialty);
}
