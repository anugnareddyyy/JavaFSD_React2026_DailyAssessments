package com.healthcare.repository;

import com.healthcare.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    List<Prescription> findByMedicineName(String medicineName);
    List<Prescription> findByPatientId(Integer patientId);

    // GreaterThan / LessThan
    List<Prescription> findByPriceGreaterThan(BigDecimal price);
    List<Prescription> findByPriceLessThan(BigDecimal price);

    // JPQL select
    @Query("SELECT p FROM Prescription p WHERE p.patient.id = :patientId")
    List<Prescription> findByPatient(@Param("patientId") int patientId);

    // Native SQL
    @Query(value = "SELECT * FROM prescriptions WHERE price < :price", nativeQuery = true)
    List<Prescription> findCheapPrescriptions(@Param("price") BigDecimal price);
}
