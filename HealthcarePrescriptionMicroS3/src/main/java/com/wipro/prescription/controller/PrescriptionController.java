
package com.wipro.prescription.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.prescription.dto.PrescriptionDTO;
import com.wipro.prescription.service.PrescriptionService;



@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service){
        this.service = service;
    }

    @PostMapping
    public PrescriptionDTO save(PrescriptionDTO dto){
        return mapper.toDTO(repo.save(mapper.toEntity(dto);
    }

    @GetMapping
    public List<PrescriptionDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/patient/{id}")
    public List<PrescriptionDTO> getByPatient(@PathVariable int id){
        return service.getByPatient(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Deleted";
    }
}

