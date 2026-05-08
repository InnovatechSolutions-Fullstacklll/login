package com.Inovatech.mslogin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private String message;
    private String token;
}