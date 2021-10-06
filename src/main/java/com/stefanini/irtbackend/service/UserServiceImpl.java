package com.stefanini.irtbackend.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stefanini.irtbackend.dao.daoimpl.UserDaoImpl;
import com.stefanini.irtbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Transactional
    public User saveUser(User user) {
        userDaoImpl.saveUser(user);
        return user;
    }

    @Transactional
    public User updateUser(User user) {
        userDaoImpl.updateUser(user);
        return user;
    }

    @Transactional
    public User deleteUser(User user) {
        return userDaoImpl.deleteUser(user);
    }

    @Transactional
    public User getUser(long id) {
        return userDaoImpl.getUser(id);
    }

}
