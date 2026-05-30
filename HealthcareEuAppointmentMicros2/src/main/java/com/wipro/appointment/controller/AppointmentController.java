package com.wipro.appointment.controller;

import com.wipro.appointment.entity.Appointment;
import com.wipro.appointment.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public Appointment add(@RequestBody Appointment a) {
        return service.save(a);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }
}