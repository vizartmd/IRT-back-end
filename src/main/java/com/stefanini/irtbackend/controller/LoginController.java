package com.stefanini.irtbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.irtbackend.dto.LoginUserDto;
import com.stefanini.irtbackend.rest.AuthenticationRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;

@RestController
public class LoginController {

//    @PostMapping("/login/{formData}")
    public String getLoginPage(@PathVariable String formData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationRequestDTO loginUserDto = objectMapper.readValue(formData, AuthenticationRequestDTO.class);
        return objectMapper.writeValueAsString(loginUserDto);
    }
}
