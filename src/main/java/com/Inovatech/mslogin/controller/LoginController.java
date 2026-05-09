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
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        return loginService.login(request);
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserAuditResponse>> getUsers() {
        return ResponseEntity.ok(loginService.getUsers());
    }
}
