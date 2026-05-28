package com.healthcare.service;

import com.healthcare.dto.DoctorDTO;
import com.healthcare.entity.Doctor;
import com.healthcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Entity → DTO
    private DoctorDTO toDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getEmail()
        );
    }

    // DTO → Entity
    private Doctor toEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setEmail(dto.getEmail());
        return doctor;
    }

    // INSERT
    public DoctorDTO save(DoctorDTO dto) {
        return toDTO(doctorRepository.save(toEntity(dto)));
    }

    // findAll
    public List<DoctorDTO> getAll() {
        return doctorRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findById
    public DoctorDTO getById(int id) {
        return doctorRepository.findById(id).map(this::toDTO).orElse(null);
    }

    // findBy specialization
    public List<DoctorDTO> getBySpecialization(String spec) {
        return doctorRepository.findBySpecialization(spec)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // UPDATE
    public DoctorDTO update(int id, DoctorDTO dto) {
        Doctor existing = doctorRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        existing.setSpecialization(dto.getSpecialization());
        existing.setEmail(dto.getEmail());
        return toDTO(doctorRepository.save(existing));
    }

    // DELETE
    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
}
