package com.stefanini.irtbackend.web.auth;

import com.stefanini.irtbackend.domain.dto.AuthenticationRequestDTO;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth")
public class AuthenticationRestController {
    private final AuthenticationService authenticationService;
    private final PasswordEncoder bc;

    public AuthenticationRestController(AuthenticationService authenticationService, PasswordEncoder bc) {
        this.authenticationService = authenticationService;
        this.bc = bc;
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserDto> authenticate(@RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
