package com.healthcare.mapper;

import org.springframework.stereotype.Component;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entity.Appointment;

@Component
public class AppointmentMapper {
	public AppointmentDTO toDTO(Appointment a){
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(a.getId());
        dto.setAppointmentDate(a.getAppointmentDate());
        dto.setStatus(a.getStatus());
        if(a.getPatient()!= null) {
        	dto.setPatientId(a.getPatient().getId());
        	dto.setPatientName(a.getPatient().getName());
        }
        if(a.getDoctor() != null) {
        	dto.setDoctorId(a.getDoctor().getId());
        	dto.setDoctorName(a.getDoctor().getName());
        }
        return dto;
    }

    public Appointment toEntity(AppointmentDTO dto){
        Appointment a = new Appointment();
        a.setId(dto.getId());
        a.setAppointmentDate(dto.getAppointmentDate());
        a.setStatus(dto.getStatus());
        return a;
    }
}


