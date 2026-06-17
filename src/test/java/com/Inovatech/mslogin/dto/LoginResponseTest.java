package com.Inovatech.mslogin.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginResponseTest {

    @Test
    void testBuilder() {

        LoginResponse response =
                LoginResponse.builder()
                        .message("ok")
                        .token("123")
                        .build();

        assertEquals(
                "ok",
                response.getMessage()
        );
    }
}