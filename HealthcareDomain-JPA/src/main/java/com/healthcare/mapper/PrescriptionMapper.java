package com.healthcare.mapper;

import org.springframework.stereotype.Component;

import com.healthcare.dto.PrescriptionDTO;
import com.healthcare.entity.Prescription;
@Component
public class PrescriptionMapper {
	public PrescriptionDTO toDTO(Prescription p){
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(p.getId());
        dto.setMedicineName(p.getMedicineName());
        dto.setDosage(p.getDosage());
        dto.setPrice(p.getPrice());
        if(p.getPatient()!= null) {
        	dto.setPatientId(p.getPatient().getId());
        	dto.setPatientName(p.getPatient().getName());
        }
        return dto;
    }

    public Prescription toEntity(PrescriptionDTO dto){
        Prescription p = new Prescription();
        p.setId(dto.getId());
        p.setMedicineName(dto.getMedicineName());
        p.setDosage(dto.getDosage());
        p.setPrice(dto.getPrice());
        return p;
    }

}
