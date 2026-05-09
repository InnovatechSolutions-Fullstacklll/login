package com.Inovatech.mslogin.service;

import com.Inovatech.mslogin.client.RegisterClient;
import com.Inovatech.mslogin.dto.LoginRequest;
import com.Inovatech.mslogin.dto.LoginResponse;
import com.Inovatech.mslogin.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final RegisterClient registerClient;

    private final JwtService jwtService;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public LoginResponse login(LoginRequest request) {

        List<UserResponse> users =
                registerClient.getUsers();

        UserResponse user = users.stream()

                .filter(u ->
                        u.getEmail()
                                .equals(request.getEmail())
                )

                .findFirst()

                .orElse(null);

        if(user == null) {

            return LoginResponse.builder()
                    .message("Usuario no encontrado")
                    .build();
        }

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if(!passwordMatches) {

            return LoginResponse.builder()
                    .message("Contraseña incorrecta")
                    .build();
        }

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return LoginResponse.builder()
                .token(token)
                .message("Login exitoso")
                .build();
    }
}
