package com.stefanini.irtbackend.sequrity;

import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.sequrity.jwt.JwtUser;
import com.stefanini.irtbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceImpl userService;

    @Autowired
    public UserDetailsServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    System.out.println("email: " + email);
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return JwtUser.fromUser(user);
    }
}
