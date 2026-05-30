package com.wipro.Appointment.service;


import com.wipro.Appointment.dto.AppointmentDTO;
import com.wipro.Appointment.mapper.AppointmentMapper;
import com.wipro.Appointment.repository.AppointmentRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository repo;
    private final AppointmentMapper mapper;
    private final RestTemplate restTemplate;

    public AppointmentService(AppointmentRepository repo,
                              AppointmentMapper mapper,
                              RestTemplate restTemplate) {
        this.repo = repo;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    // CREATE
    public AppointmentDTO save(AppointmentDTO dto){
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    // ✅ GET ALL (Patient + Prescription connected ✅)
    public List<AppointmentDTO> getAll(){
        return repo.findAll().stream().map(a -> {

            AppointmentDTO dto = mapper.toDTO(a);

            // ✅ Patient Service Call
            String patientUrl = "http://localhost:8081/patients/" + a.getPatientId();
            Object patient = restTemplate.getForObject(patientUrl, Object.class);

            // ✅ Prescription Service Call
            String presUrl = "http://localhost:8083/prescriptions/patient/" + a.getPatientId();
            Object prescriptions = restTemplate.getForObject(presUrl, Object.class);

            dto.setPatientDetails(patient);
            dto.setPrescriptions(prescriptions);

            return dto;

        }).collect(Collectors.toList());
    }

    // GET BY ID
    public AppointmentDTO getById(int id){
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    // DELETE
    public void delete(int id){
        repo.deleteById(id);
    }
}