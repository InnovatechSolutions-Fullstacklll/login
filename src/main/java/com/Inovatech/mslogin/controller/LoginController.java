package com.Inovatech.mslogin.controller;

import com.Inovatech.mslogin.dto.LoginRequest;
import com.Inovatech.mslogin.dto.LoginResponse;
import com.Inovatech.mslogin.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
