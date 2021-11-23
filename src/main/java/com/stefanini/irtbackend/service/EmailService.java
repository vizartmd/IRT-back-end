package com.stefanini.irtbackend.service;

public interface EmailService {
    void sendVerificationCodeEmail(String email, String password);
}
