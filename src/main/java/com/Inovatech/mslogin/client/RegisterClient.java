package com.Inovatech.mslogin.client;

import com.Inovatech.mslogin.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "register-service",
        url = "http://localhost:8080"
)
public interface RegisterClient {

    @GetMapping("/api/register/users")
    List<UserResponse> getUsers();
}
