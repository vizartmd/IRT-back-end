package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;

    public UserServiceImpl(@Qualifier("fake") UserDao userDao) {
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
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        User byId = userDao.findById(id);
        userDao.delete(byId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.selectUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }
}
