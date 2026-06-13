package com.wipro.appverse.controller;

/*
 * Handles authentication APIs.
 */

import com.wipro.appverse.dto.UserDTO;
import com.wipro.appverse.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // LOGIN API
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDTO user) {

        Map<String, String> response = new HashMap<>();

        if ("admin".equals(user.getUsername()) &&
            "admin".equals(user.getPassword())) {

            String token = jwtUtil.generateToken(user.getUsername());

            response.put("message", "Login successful");
            response.put("token", token);

            return response;
        }

        response.put("message", "Invalid credentials");
        return response;
    }
}