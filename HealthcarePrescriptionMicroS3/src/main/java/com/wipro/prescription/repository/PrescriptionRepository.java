
package com.wipro.prescription.repository;

import com.wipro.prescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {

    List<Prescription> findByPatientId(Integer patientId);
}
