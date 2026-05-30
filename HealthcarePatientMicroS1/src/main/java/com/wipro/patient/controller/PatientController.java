package com.wipro.patient.controller;

import org.springframework.web.bind.annotation.*;

import com.wipro.patient.dto.PatientDTO;
import com.wipro.patient.service.PatientService;

import java.util.List;

//import jakarta.print.PrintService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public PatientDTO add(@RequestBody PatientDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<PatientDTO> getAll() {
        return service.getAll();
    }
}