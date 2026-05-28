package com.healthcare.service;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entity.Appointment;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Patient;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Entity → DTO
    private AppointmentDTO toDTO(Appointment a) {
        return new AppointmentDTO(
                a.getId(),
                a.getAppointmentDate(),
                a.getStatus(),
                a.getPatient() != null ? a.getPatient().getId() : null,
                a.getPatient() != null ? a.getPatient().getName() : null,
                a.getDoctor() != null ? a.getDoctor().getId() : null,
                a.getDoctor() != null ? a.getDoctor().getName() : null
        );
    }

    // DTO → Entity
    private Appointment toEntity(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setStatus(dto.getStatus());

        if (dto.getPatientId() != null) {
            Patient patient = patientRepository.findById(dto.getPatientId()).orElse(null);
            appointment.setPatient(patient);
        }
        if (dto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
            appointment.setDoctor(doctor);
        }
        return appointment;
    }

    // INSERT
    public AppointmentDTO save(AppointmentDTO dto) {
        return toDTO(appointmentRepository.save(toEntity(dto)));
    }

    // findAll
    public List<AppointmentDTO> getAll() {
        return appointmentRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findById
    public AppointmentDTO getById(int id) {
        return appointmentRepository.findById(id).map(this::toDTO).orElse(null);
    }

    // findBy status
    public List<AppointmentDTO> getByStatus(String status) {
        return appointmentRepository.findByStatus(status)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findBy patient
    public List<AppointmentDTO> getByPatient(int patientId) {
        return appointmentRepository.findByPatientId(patientId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // UPDATE status
    public int updateStatus(int id, String status) {
        return appointmentRepository.updateStatus(id, status);
    }

    // DELETE
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }

    // DELETE by status
    public int deleteByStatus(String status) {
        return appointmentRepository.deleteByStatus(status);
    }
}
