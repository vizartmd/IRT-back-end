package com.stefanini.irtbackend.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.sequrity.jwt.JwtTokenProvider;
import com.stefanini.irtbackend.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationRestController(AuthenticationManager authenticationManager, UserServiceImpl userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

//    @PostMapping("/login")
    @PostMapping("/login/{formData}")
//    public ResponseEntity<?> authenticate(AuthenticationRequestDTO request) {
    public ResponseEntity<?> authenticate(@PathVariable String formData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationRequestDTO loginUserDto = objectMapper.readValue(formData, AuthenticationRequestDTO.class);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
            User user = userService.findByEmail(loginUserDto.getEmail());
            if (user == null) {
                throw new UsernameNotFoundException("User doesn't exists");
            }
            String token = jwtTokenProvider.createToken(loginUserDto.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("createdDate", user.getCreatedDate());
            response.put("email", user.getEmail());
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("userName", user.getUserName());
            response.put("token", token);
            response.put("role", user.getRole().name());
            response.put("specialty", user.getSpecialty());
            response.put("userStatus", user.getUserStatus());

            return ResponseEntity.ok(response);
        }catch (AuthenticationException exception) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
