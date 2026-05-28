package com.healthcare.controller;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // INSERT
    @PostMapping
    public ResponseEntity<AppointmentDTO> add(@RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(appointmentService.save(dto));
    }

    // findAll
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        return ResponseEntity.ok(appointmentService.getAll());
    }

    // findById
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable int id) {
        AppointmentDTO dto = appointmentService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // findBy status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AppointmentDTO>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(appointmentService.getByStatus(status));
    }

    // findBy patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentDTO>> getByPatient(@PathVariable int patientId) {
        return ResponseEntity.ok(appointmentService.getByPatient(patientId));
    }

    // UPDATE status (JPQL)
    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id,
                                                @RequestParam String status) {
        appointmentService.updateStatus(id, status);
        return ResponseEntity.ok("Status updated to " + status);
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }

    // JPQL DELETE by status
    @DeleteMapping("/status/{status}")
    public ResponseEntity<String> deleteByStatus(@PathVariable String status) {
        int count = appointmentService.deleteByStatus(status);
        return ResponseEntity.ok(count + " appointments deleted");
    }
}
