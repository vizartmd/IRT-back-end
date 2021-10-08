package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

@Repository
class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    UserDaoImpl() {
        super(User.class);
    }
}
