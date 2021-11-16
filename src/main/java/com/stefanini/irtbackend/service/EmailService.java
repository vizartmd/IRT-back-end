package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.entity.Response;

public interface EmailService {
    Response sendEmail(String email);
}
