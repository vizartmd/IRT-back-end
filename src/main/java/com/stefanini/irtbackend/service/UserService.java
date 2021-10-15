package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void deleteById(Long id);

    List<User> findAll();
}
