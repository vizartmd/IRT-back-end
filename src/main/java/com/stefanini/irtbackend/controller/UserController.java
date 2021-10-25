package com.stefanini.irtbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.rest.AuthenticationRequestDTO;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    @PreAuthorize("hasAuthority('developers:read')")
//    ResponseEntity<List<User>> findAll() {
//        return ResponseEntity.ok(userService.findAll());
//    }
    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() throws IOException {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    boolean create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('developers:write')")
    ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}