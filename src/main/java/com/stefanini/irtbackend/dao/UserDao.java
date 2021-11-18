package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.domain.entity.User;

import java.util.List;

import java.util.Optional;


public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);

    List<String> findAllUsernamesBySpecialty(String specialty);

    List<User> findAllBySpecialty(String specialty);

    Optional<User> findByEmail(String email);

}
