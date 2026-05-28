package com.healthcare.controller;

import com.healthcare.dto.DoctorDTO;
import com.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // INSERT
    @PostMapping
    public ResponseEntity<DoctorDTO> add(@RequestBody DoctorDTO dto) {
        return ResponseEntity.ok(doctorService.save(dto));
    }

    // findAll
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    // findById
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getById(@PathVariable int id) {
        DoctorDTO dto = doctorService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // findBy specialization
    @GetMapping("/specialization/{spec}")
    public ResponseEntity<List<DoctorDTO>> getBySpec(@PathVariable String spec) {
        return ResponseEntity.ok(doctorService.getBySpecialization(spec));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> update(@PathVariable int id,
                                             @RequestBody DoctorDTO dto) {
        DoctorDTO updated = doctorService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        doctorService.delete(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
