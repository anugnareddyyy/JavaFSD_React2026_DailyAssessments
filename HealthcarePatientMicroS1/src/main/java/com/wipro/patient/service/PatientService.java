package com.wipro.patient.service;

import org.springframework.stereotype.Service;

import com.wipro.patient.dto.PatientDTO;
import com.wipro.patient.mapper.PatientMapper;
import com.wipro.patient.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository repo;
    private final PatientMapper mapper;

    public PatientService(PatientRepository repo, PatientMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PatientDTO save(PatientDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    public List<PatientDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}