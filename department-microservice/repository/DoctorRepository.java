package com.healthcare.repository;

import com.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findBySpecialization(String specialization);
    Doctor findByEmail(String email);

    // JPQL select
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :spec")
    List<Doctor> getDoctorsBySpec(@Param("spec") String spec);

    // JPQL DML update
    @Query("UPDATE Doctor d SET d.specialization = :spec WHERE d.id = :id")
    int updateSpecialization(@Param("id") int id, @Param("spec") String spec);

    // Native SQL
    @Query(value = "SELECT * FROM doctors WHERE specialization = :spec", nativeQuery = true)
    List<Doctor> findDoctorsBySpecNative(@Param("spec") String spec);
}
