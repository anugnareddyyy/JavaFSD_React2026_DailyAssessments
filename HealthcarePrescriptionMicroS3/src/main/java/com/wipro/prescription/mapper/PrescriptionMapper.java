package com.wipro.prescription.mapper;

import org.springframework.stereotype.Component;

import com.wipro.prescription.dto.PrescriptionDTO;
import com.wipro.prescription.entity.Prescription;

@Component
public class PrescriptionMapper {

    public PrescriptionDTO toDTO(Prescription p){
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(p.getId());
        dto.setMedicineName(p.getMedicineName());
        dto.setDosage(p.getDosage());
        dto.setPrice(p.getPrice());
        dto.setPatientId(p.getPatientId());
        dto.setDisease(p.getDiseases());
        return dto;
    }

    public Prescription toEntity(PrescriptionDTO dto){
        Prescription p = new Prescription();
        p.setId(dto.getId());
        p.setMedicineName(dto.getMedicineName());
        p.setDosage(dto.getDosage());
        p.setPrice(dto.getPrice());
        p.setPatientId(Integer)(dto.getPatientId());
        p.setDisease( dto.getDiseases());
        return p;
    }

}