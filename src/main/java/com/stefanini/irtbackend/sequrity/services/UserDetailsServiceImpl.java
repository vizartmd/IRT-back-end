package com.stefanini.irtbackend.sequrity.services;

import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.sequrity.SequrityUser;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists")
        );
        return SequrityUser.fromUser(user);
    }
}
