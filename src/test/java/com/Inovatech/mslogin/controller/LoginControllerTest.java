package com.Inovatech.mslogin.controller;

import com.Inovatech.mslogin.dto.*;
import com.Inovatech.mslogin.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController controller;

    @Test
    void login() {

        LoginRequest request =
                new LoginRequest(
                        "test@test.com",
                        "123456"
                );

        LoginResponse response =
                LoginResponse.builder()
                        .message("ok")
                        .token("token")
                        .build();

        when(loginService.login(request))
                .thenReturn(response);

        LoginResponse result =
                controller.login(request);

        assertEquals(
                "ok",
                result.getMessage()
        );
    }

    @Test
    void getUsers() {

        when(loginService.getUsers())
                .thenReturn(
                        List.of(
                                new UserAuditResponse(
                                        "test@test.com"
                                )
                        )
                );

        ResponseEntity<List<UserAuditResponse>> response =
                controller.getUsers();

        assertEquals(
                1,
                response.getBody().size()
        );
    }
}