package com.dev.spring_boot.service;

import com.dev.spring_boot.dto.AuthenticationRequest;
import com.dev.spring_boot.dto.IntrospectRequest;
import com.dev.spring_boot.response.AuthenticationResponse;
import com.dev.spring_boot.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect (IntrospectRequest request) throws JOSEException, ParseException;
}
