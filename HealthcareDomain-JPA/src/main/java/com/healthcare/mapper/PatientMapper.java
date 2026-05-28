package com.healthcare.mapper;

import org.springframework.stereotype.Component;

import com.healthcare.dto.PatientDTO;
import com.healthcare.entity.Patient;

@Component
public class PatientMapper {

    public PatientDTO toDTO(Patient p){
        PatientDTO dto = new PatientDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setEmail(p.getEmail());
        dto.setAge(p.getAge());
        dto.setDisease(p.getDisease());
        return dto;
    }

    public Patient toEntity(PatientDTO dto){
        Patient p = new Patient();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setAge(dto.getAge());
        p.setDisease(dto.getDisease());
        return p;
    }
}