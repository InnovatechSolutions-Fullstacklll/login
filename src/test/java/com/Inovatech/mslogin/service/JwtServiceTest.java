package com.Inovatech.mslogin.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    @Test
    void generateToken() {

        JwtService jwtService =
                new JwtService();

        String token =
                jwtService.generateToken(
                        "camilo@test.com"
                );

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}