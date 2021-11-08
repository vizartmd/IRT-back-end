package com.stefanini.irtbackend.config.security.jwt.exception;

import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus httpStatus;

    public JwtAuthenticationException(String explanation) {
        super(explanation);
    }

    public JwtAuthenticationException(String s, HttpStatus httpStatus) {
        super(s);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
