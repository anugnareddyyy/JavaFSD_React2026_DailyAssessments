package com.wipro.appverse.controller;

/*
 * Handles authentication APIs.
 */
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.wipro.appverse.dto.UserDTO;
import com.wipro.appverse.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {

        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return ResponseEntity.ok(Map.of("token", "dummy-token"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid credentials"));
    }
}