package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.dto.ChangePasswordRequest;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/roles")
    public ResponseEntity<RoleName[]> getRoleNames() {
        return ResponseEntity.ok(RoleName.values());
    }

    @GetMapping("/specialties")
    public ResponseEntity<SpecialtyName[]> getSpecialtyNames() {
        return ResponseEntity.ok(SpecialtyName.values());
    }

    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/specialty/{specialty}")
    ResponseEntity<List<String>> findAllUsernamesBySpecialty(@PathVariable("specialty") String specialty) {
        return ResponseEntity.ok(userService.findAllUsernamesBySpecialty(specialty));
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


    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePasswordFor(@PathVariable("id") Long id, @RequestBody ChangePasswordRequest request) {
        userService.changePasswordFor(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<?> update(@RequestBody UserDto userDto) {
        User user = null;
        try {
            user = (userService.updateWithDto(userDto));
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Duplicate entry");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
