package com.ordersphere.auth_service.controller;

import com.ordersphere.auth_service.dto.AuthRequest;
import com.ordersphere.auth_service.dto.AuthResponse;
import com.ordersphere.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String newUserRegister(@RequestBody AuthRequest req){
        authService.newuserRegister(req);
        return "User Registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req){
        String token = authService.login(req);
        return new AuthResponse(token);

    }

}
