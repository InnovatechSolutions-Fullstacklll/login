package com.Inovatech.mslogin.service;

import com.Inovatech.mslogin.dto.LoginRequest;
import com.Inovatech.mslogin.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        /*TEMPORAL:luego validaremos contra db real*/

        String token = jwtService.generateToken(
                request.getEmail()
        );

        return LoginResponse.builder()
                .message("Login exitoso")
                .token(token)
                .build();
    }
}
