package com.Inovatech.mslogin.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void testDto() {

        LoginRequest dto =
                new LoginRequest(
                        "test@test.com",
                        "123456"
                );

        assertEquals(
                "test@test.com",
                dto.getEmail()
        );

        assertEquals(
                "123456",
                dto.getClave1()
        );
    }
}