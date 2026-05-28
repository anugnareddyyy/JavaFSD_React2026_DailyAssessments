package com.healthcare.service;

import com.healthcare.dto.PatientDTO;
import com.healthcare.entity.Patient;
import com.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // ---- Conversion Methods ----

    // Entity → DTO
    private PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAge(),
                patient.getDisease()
        );
    }

    // DTO → Entity
    private Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setAge(dto.getAge());
        patient.setDisease(dto.getDisease());
        return patient;
    }

    // ---- Service Methods ----

    // INSERT
    public PatientDTO save(PatientDTO dto) {
        Patient saved = patientRepository.save(toEntity(dto));
        return toDTO(saved);
    }

    // findAll sorted
    public List<PatientDTO> getAllSorted() {
        return patientRepository.findAll(Sort.by("name"))
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findById
    public PatientDTO getById(int id) {
        return patientRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // findBy disease
    public List<PatientDTO> getByDisease(String disease) {
        return patientRepository.findByDisease(disease)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findByAgeGreaterThan
    public List<PatientDTO> getOlderThan(int age) {
        return patientRepository.findByAgeGreaterThan(age)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findByAgeLessThan
    public List<PatientDTO> getYoungerThan(int age) {
        return patientRepository.findByAgeLessThan(age)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // UPDATE
    public PatientDTO update(int id, PatientDTO dto) {
        Patient existing = patientRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setAge(dto.getAge());
        existing.setDisease(dto.getDisease());
        return toDTO(patientRepository.save(existing));
    }

    // DELETE
    public void delete(int id) {
        patientRepository.deleteById(id);
    }

    // JPQL update disease
    public int updateDisease(int id, String disease) {
        return patientRepository.updateDiseaseById(id, disease);
    }

    // JPQL delete by disease
    public int deleteByDisease(String disease) {
        return patientRepository.deleteByDisease(disease);
    }

    // JPQL search by name
    public List<PatientDTO> searchByName(String name) {
        return patientRepository.findByNameContaining(name)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Native query - older than age
    public List<PatientDTO> getOlderThanNative(int age) {
        return patientRepository.findPatientsOlderThan(age)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }
}
