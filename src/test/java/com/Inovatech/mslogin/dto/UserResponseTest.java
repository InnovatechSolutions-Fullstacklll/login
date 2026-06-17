package com.Inovatech.mslogin.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseTest {

    @Test
    void testDto() {

        UserResponse dto =
                new UserResponse(
                        1L,
                        "Camilo",
                        "test@test.com",
                        "123"
                );

        assertEquals(
                "Camilo",
                dto.getNombre()
        );
    }
}