package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public User saveUser(User user);

    public User deleteUser(User user);

    public User updateUser(User user);

    public User getUser(long id);

}
