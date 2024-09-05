package com.dev.spring_boot.service.impl;

import com.dev.spring_boot.dto.AuthenticationRequest;
import com.dev.spring_boot.exception.AppException;
import com.dev.spring_boot.exception.ErrorCode;
import com.dev.spring_boot.repositoty.UserRepository;
import com.dev.spring_boot.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public boolean authenticate(AuthenticationRequest request) {
        var user= userRepository.findByUsername(request.getUsername()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
