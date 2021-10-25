package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new NotFoundException("Not found user with id = " + id));
    }

    @Override
    @Transactional
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        User byId = userDao.findById(id).orElseThrow(() -> new NotFoundException("Not found user with id = " + id));
        userDao.delete(byId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
