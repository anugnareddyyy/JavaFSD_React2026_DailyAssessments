package com.healthcare.repository;

import com.healthcare.entity.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // findAll sorted
    List<Patient> findAll(Sort sort);

    // findBy property
    Patient findByEmail(String email);
    List<Patient> findByDisease(String disease);

    // findBy GreaterThan / LessThan
    List<Patient> findByAgeGreaterThan(int age);
    List<Patient> findByAgeLessThan(int age);

    // JPQL - select
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:name%")
    List<Patient> findByNameContaining(@Param("name") String name);

    // JPQL - DML update
    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.disease = :disease WHERE p.id = :id")
    int updateDiseaseById(@Param("id") int id, @Param("disease") String disease);

    // JPQL - DML delete
    @Modifying
    @Transactional
    @Query("DELETE FROM Patient p WHERE p.disease = :disease")
    int deleteByDisease(@Param("disease") String disease);

    // Native SQL query
    @Query(value = "SELECT * FROM patients WHERE age > :age", nativeQuery = true)
    List<Patient> findPatientsOlderThan(@Param("age") int age);
}
