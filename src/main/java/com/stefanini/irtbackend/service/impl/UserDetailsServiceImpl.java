package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.security.UserSecurityDetails;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.selectUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", username)));

        String password = user.getPassword();
        UserRole userRole = user.getRole();

        return new UserSecurityDetails(username, password, userRole.getGrantedAuthorities());
    }
}
