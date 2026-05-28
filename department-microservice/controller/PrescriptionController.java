package com.healthcare.controller;

import com.healthcare.dto.PrescriptionDTO;
import com.healthcare.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // INSERT
    @PostMapping
    public ResponseEntity<PrescriptionDTO> add(@RequestBody PrescriptionDTO dto) {
        return ResponseEntity.ok(prescriptionService.save(dto));
    }

    // findAll
    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAll() {
        return ResponseEntity.ok(prescriptionService.getAll());
    }

    // findById
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getById(@PathVariable int id) {
        PrescriptionDTO dto = prescriptionService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // findBy patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PrescriptionDTO>> getByPatient(@PathVariable int patientId) {
        return ResponseEntity.ok(prescriptionService.getByPatient(patientId));
    }

    // findByPriceGreaterThan
    @GetMapping("/price/greater/{price}")
    public ResponseEntity<List<PrescriptionDTO>> getByPriceGreater(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(prescriptionService.getByPriceGreaterThan(price));
    }

    // findByPriceLessThan
    @GetMapping("/price/less/{price}")
    public ResponseEntity<List<PrescriptionDTO>> getByPriceLess(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(prescriptionService.getByPriceLessThan(price));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> update(@PathVariable int id,
                                                   @RequestBody PrescriptionDTO dto) {
        PrescriptionDTO updated = prescriptionService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        prescriptionService.delete(id);
        return ResponseEntity.ok("Prescription deleted successfully");
    }
}
