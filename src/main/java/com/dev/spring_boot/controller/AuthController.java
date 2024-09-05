package com.dev.spring_boot.controller;

import com.dev.spring_boot.dto.ApiResponse;
import com.dev.spring_boot.dto.AuthenticationRequest;
import com.dev.spring_boot.response.AuthenticationResponse;
import com.dev.spring_boot.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean resultAuth = authService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(resultAuth)
                        .build())
                .build();
    }
}
