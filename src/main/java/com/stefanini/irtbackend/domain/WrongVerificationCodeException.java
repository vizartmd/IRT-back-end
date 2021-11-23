package com.stefanini.irtbackend.domain;

public class WrongVerificationCodeException extends RuntimeException {
    public WrongVerificationCodeException(String message) {
        super(message);
    }
}
