package com.stefanini.irtbackend.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.dto.UserForRegistrationDTO;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('users:read')")
    ResponseEntity<User> findById(@PathVariable("id") String id) {
        String _id = id.replaceAll("\\D+","");
        System.out.println("id: " + id);
        return ResponseEntity.ok(userService.findById(Long.parseLong(_id)));
    }

//    @PutMapping("/userName")
    @PreAuthorize("hasAuthority('users:read')")
    public User getUserByUsername(@RequestBody Map<String, String> request) {
        return userService.findByUsername(request.get("userName"));
    }

    @CrossOrigin
    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<User> create(@RequestBody UserForRegistrationDTO userDto){
        User newUser = new User();
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setUsername(userDto.getUserName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());
        newUser.setSpecialty(userDto.getSpecialty());
        System.out.println("newUser.toString() : " + newUser.toString());
        User createdUser = userService.create(newUser);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @CrossOrigin
    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<User> update(@RequestBody UserForRegistrationDTO userDto) {
//        System.out.println("userDto.toString() : " + userDto.toString());
        Long id = Long.parseLong(userDto.getId().replaceAll("\\D+",""));
        User userFromDb = userService.findById(id);
        userFromDb.setFirstName(userDto.getFirstName());
        userFromDb.setLastName(userDto.getLastName());
        userFromDb.setUsername(userDto.getUserName());
        userFromDb.setEmail(userDto.getEmail());
        userFromDb.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userFromDb.setRole(userDto.getRole());
        userFromDb.setSpecialty(userDto.getSpecialty());
        System.out.println("updatedUser.toString() : " + userFromDb.toString());
        User userAfterUpdate = userService.update(userFromDb);
        return ResponseEntity.created(URI.create("/users/" + userAfterUpdate.getId())).body(userAfterUpdate);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('users:write')")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
