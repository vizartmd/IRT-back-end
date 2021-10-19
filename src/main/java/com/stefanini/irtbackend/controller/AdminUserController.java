package com.stefanini.irtbackend.controller;

import com.stefanini.irtbackend.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("admin/users")
public class AdminUserController {

    private static final List<User> USERS = Arrays.asList(
//            new User(1l,"James Bond"),
//            new User(2l,"Maria Jones"),
//            new User(3l,"Anna Smith")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<User> getAllUsers(){
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewStudent(@RequestBody User user){
        System.out.println(user.toString());
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void update(@PathVariable("userId") Integer userId, User user){
        System.out.println(String.format("%s %s", userId, user.toString()));
    }
}
