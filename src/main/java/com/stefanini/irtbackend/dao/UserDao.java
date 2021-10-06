package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.entity.User;

import java.sql.SQLException;

public interface UserDao {

    public User saveUser(User user) throws SQLException;

    public User deleteUser(User user);

    public User updateUser(User user);

    public User getUser(long id);

}
