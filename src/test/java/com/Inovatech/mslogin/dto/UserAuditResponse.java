package com.Inovatech.mslogin.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAuditResponseTest {

    @Test
    void testDto() {

        UserAuditResponse dto =
                new UserAuditResponse(
                        "test@test.com"
                );

        assertEquals(
                "test@test.com",
                dto.getEmail()
        );
    }
}