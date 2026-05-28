package com.healthcare.mapper;

import org.springframework.stereotype.Component;

import com.healthcare.dto.DoctorDTO;
import com.healthcare.entity.Doctor;

@Component
public class DoctorMapper {
	public DoctorDTO toDTO(Doctor d){
        DoctorDTO dto = new DoctorDTO();
        dto.setId(d.getId());
        dto.setName(d.getName());
        dto.setSpecialization(d.getSpecialization());
        dto.setEmail(d.getEmail());
        return dto;
    }

    public Doctor toEntity(DoctorDTO dto){
        Doctor d = new Doctor();
        d.setId(dto.getId());
        d.setName(dto.getName());
        d.setSpecialization(dto.getSpecialization());
        d.setEmail(dto.getEmail());
        return d;
    }

}
