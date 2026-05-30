package com.wipro.patient.mapper;

import org.springframework.stereotype.Component;

import com.wipro.patient.dto.PatientDTO;
import com.wipro.patient.entity.Patient;

@Component

//public Integer getId() { return id; }
//public void setId(Integer id) { this.id = id; }

public class PatientMapper {

    public PatientDTO toDTO(Patient p) {
    	if(p== null) return null;
        PatientDTO dto = new PatientDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setEmail(p.getEmail());
        dto.setId(p.getId());
        dto.setDisease(p.getDisease());
        return dto;
    }

    public Patient toEntity(PatientDTO dto) {
    	if(dto == null) return null;
        Patient p = new Patient();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setAge(dto.getAge());
        p.setDisease(dto.getDisease());
        return p;
    }
}