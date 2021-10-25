package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.User;

import java.util.List;

public interface UserService {

    boolean create(User user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    void deleteById(Long id);

    List<User> findAll();

    User findByEmail(String email);

    User findByUsername(String username);
}
