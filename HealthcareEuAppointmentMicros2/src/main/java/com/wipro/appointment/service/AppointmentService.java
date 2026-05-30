package com.wipro.appointment.service;

import com.wipro.appointment.entity.Appointment;
import com.wipro.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentService(AppointmentRepository repo) {
        this.repo = repo;
    }

    public Appointment save(Appointment a) {
        return repo.save(a);
    }

    public List<Appointment> getAll() {
        return repo.findAll();
    }
}