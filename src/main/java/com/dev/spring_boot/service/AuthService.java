package com.dev.spring_boot.service;

import com.dev.spring_boot.dto.AuthenticationRequest;

public interface AuthService {
    boolean authenticate(AuthenticationRequest request);
}
