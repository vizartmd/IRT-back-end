package com.stefanini.irtbackend.rest;

import com.stefanini.irtbackend.dto.UserDto;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {

    private UserServiceImpl userService;

    @Autowired
    public AdminRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto userDto = new UserDto().fromUser(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
