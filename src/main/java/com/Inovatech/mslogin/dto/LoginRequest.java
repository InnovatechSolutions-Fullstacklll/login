package com.Inovatech.mslogin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Email(message = "Email inválido")
    @NotBlank(message = "Email obligatorio")
    private String email;

    @NotBlank(message = "contraseña obligatoria")
    private String clave1;
}