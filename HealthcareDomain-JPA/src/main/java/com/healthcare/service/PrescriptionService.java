package com.healthcare.service;

import com.healthcare.dto.PrescriptionDTO;
import com.healthcare.entity.Patient;
import com.healthcare.entity.Prescription;
import com.healthcare.repository.PatientRepository;
import com.healthcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Entity → DTO
    private PrescriptionDTO toDTO(Prescription p) {
        return new PrescriptionDTO(
                p.getId(),
                p.getMedicineName(),
                p.getDosage(),
                p.getPrice(),
                p.getPatient() != null ? p.getPatient().getId() : null,
                p.getPatient() != null ? p.getPatient().getName() : null
        );
    }

    // DTO → Entity
    private Prescription toEntity(PrescriptionDTO dto) {
        Prescription prescription = new Prescription();
        prescription.setMedicineName(dto.getMedicineName());
        prescription.setDosage(dto.getDosage());
        prescription.setPrice(dto.getPrice());

        if (dto.getPatientId() != null) {
            Patient patient = patientRepository.findById(dto.getPatientId()).orElse(null);
            prescription.setPatient(patient);
        }
        return prescription;
    }

    // INSERT
    public PrescriptionDTO save(PrescriptionDTO dto) {
        return toDTO(prescriptionRepository.save(toEntity(dto)));
    }

    // findAll
    public List<PrescriptionDTO> getAll() {
        return prescriptionRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findById
    public PrescriptionDTO getById(int id) {
        return prescriptionRepository.findById(id).map(this::toDTO).orElse(null);
    }

    // findBy patient
    public List<PrescriptionDTO> getByPatient(int patientId) {
        return prescriptionRepository.findByPatientId(patientId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findByPriceGreaterThan
    public List<PrescriptionDTO> getByPriceGreaterThan(BigDecimal price) {
        return prescriptionRepository.findByPriceGreaterThan(price)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // findByPriceLessThan
    public List<PrescriptionDTO> getByPriceLessThan(BigDecimal price) {
        return prescriptionRepository.findByPriceLessThan(price)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // UPDATE
    public PrescriptionDTO update(int id, PrescriptionDTO dto) {
        Prescription existing = prescriptionRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setMedicineName(dto.getMedicineName());
        existing.setDosage(dto.getDosage());
        existing.setPrice(dto.getPrice());
        return toDTO(prescriptionRepository.save(existing));
    }

    // DELETE
    public void delete(int id) {
        prescriptionRepository.deleteById(id);
    }
}
