package com.wipro.Appointment.mapper;

import com.wipro.Appointment.entity.Appointment;
import com.wipro.Appointment.dto.AppointmentDTO;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDTO(Appointment a){
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(a.getId());
        dto.setAppointmentDate(a.getAppointmentDate());
        dto.setStatus(a.getStatus());
        dto.setPatientDetails(a.getPatientId());
        return dto;
    }

    public Appointment toEntity(AppointmentDTO dto){
        Appointment a = new Appointment();
        a.setId(dto.getId());
        a.setAppointmentDate(dto.getAppointmentDate());
        a.setStatus(dto.getStatus());
        a.setPatientId(dto.getPatientId());
        return a;
    }
}