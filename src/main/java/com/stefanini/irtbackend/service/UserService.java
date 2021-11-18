package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    User updateWithDto(UserDto userDto);

    void delete(User user);

    User findById(Long id);

    User findByUsername(String userName);

    void deleteById(Long id);

    List<User> findAll();

    User findByEmail(String email);

    List<String> findAllUsernamesBySpecialty(String specialty);
}
