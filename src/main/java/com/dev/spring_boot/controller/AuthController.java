package com.dev.spring_boot.controller;

import com.dev.spring_boot.dto.ApiResponse;
import com.dev.spring_boot.dto.AuthenticationRequest;
import com.dev.spring_boot.dto.IntrospectRequest;
import com.dev.spring_boot.response.AuthenticationResponse;
import com.dev.spring_boot.response.IntrospectResponse;
import com.dev.spring_boot.service.AuthService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var resultAuth = authService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(resultAuth)
                .build();
    }


    @PostMapping("/intros")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var resultAuth = authService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(resultAuth)
                .build();
    }
}
