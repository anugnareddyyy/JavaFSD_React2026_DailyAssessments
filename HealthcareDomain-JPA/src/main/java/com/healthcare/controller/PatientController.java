package com.healthcare.controller;

import com.healthcare.dto.PatientDTO;
import com.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // INSERT
    @PostMapping
    public ResponseEntity<PatientDTO> add(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.save(dto));
    }

    // findAll sorted by name
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAll() {
        return ResponseEntity.ok(patientService.getAllSorted());
    }

    // findById
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable int id) {
        PatientDTO dto = patientService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // findBy disease
    @GetMapping("/disease/{disease}")
    public ResponseEntity<List<PatientDTO>> getByDisease(@PathVariable String disease) {
        return ResponseEntity.ok(patientService.getByDisease(disease));
    }

    // findByAgeGreaterThan
    @GetMapping("/age/greater/{age}")
    public ResponseEntity<List<PatientDTO>> getOlderThan(@PathVariable int age) {
        return ResponseEntity.ok(patientService.getOlderThan(age));
    }

    // findByAgeLessThan
    @GetMapping("/age/less/{age}")
    public ResponseEntity<List<PatientDTO>> getYoungerThan(@PathVariable int age) {
        return ResponseEntity.ok(patientService.getYoungerThan(age));
    }

    // Search by name (JPQL)
    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(patientService.searchByName(name));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable int id,
                                              @RequestBody PatientDTO dto) {
        PatientDTO updated = patientService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // JPQL update disease
    @PutMapping("/update-disease/{id}")
    public ResponseEntity<String> updateDisease(@PathVariable int id,
                                                 @RequestParam String disease) {
        patientService.updateDisease(id, disease);
        return ResponseEntity.ok("Disease updated successfully");
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    // JPQL delete by disease
    @DeleteMapping("/delete-disease/{disease}")
    public ResponseEntity<String> deleteByDisease(@PathVariable String disease) {
        int count = patientService.deleteByDisease(disease);
        return ResponseEntity.ok(count + " patients deleted");
    }

    // Native query - older than age
    @GetMapping("/native/age/{age}")
    public ResponseEntity<List<PatientDTO>> getOlderThanNative(@PathVariable int age) {
        return ResponseEntity.ok(patientService.getOlderThanNative(age));
    }
}
