package com.Inovatech.mslogin.service;

import com.Inovatech.mslogin.client.RegisterClient;
import com.Inovatech.mslogin.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private RegisterClient registerClient;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private LoginService loginService;

    @Test
    void loginUsuarioNoExiste() {

        when(registerClient.getUsers())
                .thenReturn(List.of());

        LoginRequest request =
                new LoginRequest(
                        "test@test.com",
                        "123456"
                );

        LoginResponse response =
                loginService.login(request);

        assertEquals(
                "Usuario no encontrado",
                response.getMessage()
        );
    }

    @Test
    void loginPasswordIncorrecta() {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        UserResponse user =
                new UserResponse(
                        1L,
                        "Camilo",
                        "camilo@test.com",
                        encoder.encode("123456")
                );

        when(registerClient.getUsers())
                .thenReturn(List.of(user));

        LoginRequest request =
                new LoginRequest(
                        "camilo@test.com",
                        "incorrecta"
                );

        LoginResponse response =
                loginService.login(request);

        assertEquals(
                "Contraseña incorrecta",
                response.getMessage()
        );
    }

    @Test
    void loginCorrecto() {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        UserResponse user =
                new UserResponse(
                        1L,
                        "Camilo",
                        "camilo@test.com",
                        encoder.encode("123456")
                );

        when(registerClient.getUsers())
                .thenReturn(List.of(user));

        when(jwtService.generateToken(
                "camilo@test.com"))
                .thenReturn("TOKEN123");

        LoginRequest request =
                new LoginRequest(
                        "camilo@test.com",
                        "123456"
                );

        LoginResponse response =
                loginService.login(request);

        assertEquals(
                "Login exitoso",
                response.getMessage()
        );

        assertEquals(
                "TOKEN123",
                response.getToken()
        );
    }

    @Test
    void getUsers() {

        UserResponse user1 =
                new UserResponse(
                        1L,
                        "A",
                        "a@test.com",
                        "123"
                );

        UserResponse user2 =
                new UserResponse(
                        2L,
                        "B",
                        "b@test.com",
                        "456"
                );

        when(registerClient.getUsers())
                .thenReturn(List.of(user1, user2));

        List<UserAuditResponse> response =
                loginService.getUsers();

        assertEquals(2, response.size());

        assertEquals(
                "a@test.com",
                response.get(0).getEmail()
        );
    }
}