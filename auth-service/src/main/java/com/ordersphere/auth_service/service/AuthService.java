package com.ordersphere.auth_service.service;

import com.ordersphere.auth_service.dao.UserRepository;
import com.ordersphere.auth_service.dto.AuthRequest;
import com.ordersphere.auth_service.dto.AuthResponse;
import com.ordersphere.auth_service.entity.User;
import com.ordersphere.auth_service.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository repo;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder encoder;

//    Creating new user by reading values from request and setting in User bean
    public void newuserRegister (AuthRequest req){

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRole("User");
        repo.save(user);
    }

//    User login validation - If email and password matched generating jwt token
    public String login(AuthRequest req) {

        User user = repo.findByEmail(req.getEmail()).orElseThrow();

        if (!encoder.matches(req.password, user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }

            return jwtUtil.generateToken(req.getEmail());

    }


}
