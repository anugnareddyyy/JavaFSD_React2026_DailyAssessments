package com.wipro.Appointment.controller;

import com.wipro.Appointment.dto.AppointmentDTO;

import com.wipro.Appointment.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    @PostMapping
    public AppointmentDTO add(@RequestBody AppointmentDTO dto){
        return service.save(dto);
    }

    @GetMapping
    public List<AppointmentDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getById(@PathVariable int id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Deleted";
    }
}


