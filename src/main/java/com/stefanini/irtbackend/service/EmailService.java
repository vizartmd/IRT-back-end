package com.stefanini.irtbackend.service;

public interface EmailService {
    void sendResetPasswordEmail(String email, String password);
}
