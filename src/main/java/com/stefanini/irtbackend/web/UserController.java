package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/userName")
    @PreAuthorize("hasAuthority('users:read')")
    public User getUserByUsername(@RequestBody Map<String, String> request) {
        return userService.findByUsername(request.get("userName"));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
