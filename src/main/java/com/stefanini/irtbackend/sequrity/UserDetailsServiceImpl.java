package com.stefanini.irtbackend.sequrity;

import com.stefanini.irtbackend.dao.impl.UserDaoImpl;
import com.stefanini.irtbackend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl {

}
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserDaoImpl userDao;
//
//    public UserDetailsServiceImpl(UserDaoImpl userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userDao.findByEmail(email);
//        return SecurityUser.fromUser(user);
//    }
//}
