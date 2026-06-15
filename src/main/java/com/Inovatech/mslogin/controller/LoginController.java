package com.Inovatech.mslogin.controller;

import com.Inovatech.mslogin.dto.LoginRequest;
import com.Inovatech.mslogin.dto.LoginResponse;
import com.Inovatech.mslogin.dto.UserAuditResponse;
import com.Inovatech.mslogin.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /*@PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {

        System.out.println("EMAIL: " + request.getEmail());
        System.out.println("CLAVE1: " + request.getClave1());

        return loginService.login(request);
    }*/

    @PostMapping
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {
        System.out.println(request);
        return loginService.login(request);
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserAuditResponse>> getUsers() {
        return ResponseEntity.ok(loginService.getUsers());
    }
}
