package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.entity.Response;

public interface EmailService {
    Response sendResetPasswordEmail(String email, String password);
}
