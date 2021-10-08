package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    UserDaoImpl() {
        super(User.class);
    }
}
