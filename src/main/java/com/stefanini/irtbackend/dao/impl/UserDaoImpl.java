package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @PersistenceContext
    protected EntityManager entityManager;

    UserDaoImpl() {
        super(User.class);
    }

    // TODO
    @Override
    public User findByUserName(String userName) {
        List<User> users = findAll();
        for (User u : users) {
            System.out.println("User from findByUserName(): " + u);
        }
        User user = users.stream().filter(u -> u.getUserName().equals(userName)).findFirst().orElse(null);
        System.out.println("User after filter users.stream().filter: " + user);
        return user;
    }

    // TODO
    @Override
    public User findByEmail(String email) {
        List<User> users = findAll();
        for (User u : users) {
            System.out.println("User from findByEmail(): " + u);
        }
        User user = users.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
        System.out.println("User after filter users.stream().filter: " + user);
        return user;
    }
}