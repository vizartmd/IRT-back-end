package com.stefanini.irtbackend.controller;

import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findall")
    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping("/find_by_id")
    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @RequestMapping("/create")
    @PostMapping
    ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @RequestMapping("/update")
    @PutMapping
    ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @RequestMapping("/delete")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

