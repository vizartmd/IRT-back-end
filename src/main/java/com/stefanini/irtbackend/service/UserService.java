package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    void deleteById(Long id);

    List<User> findAll();

    Optional<User> findByUsername(String username);
}
