package com.wipro.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {}