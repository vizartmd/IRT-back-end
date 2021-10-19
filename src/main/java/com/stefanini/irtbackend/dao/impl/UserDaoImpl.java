package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    UserDaoImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> selectUserByUsername(String userName) {
        return super.findAll().stream().filter(user -> userName.equals(user.getUsername())).findFirst();
    }
}
