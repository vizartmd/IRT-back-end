package com.stefanini.irtbackend.domain;

public class PasswordsMismatchException extends RuntimeException {
    public PasswordsMismatchException(String message) {
        super(message);
    }
}
