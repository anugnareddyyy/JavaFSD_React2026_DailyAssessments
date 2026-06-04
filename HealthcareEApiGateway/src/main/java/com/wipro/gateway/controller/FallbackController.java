package com.wipro.gateway.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/patient")
    public String patientFallback() {
        return "Patient service is DOWN (Gateway fallback)";
    }

    @GetMapping("/appointment")
    public String appointmentFallback() {
        return "Appointment service is DOWN (Gateway fallback)";
    }
}