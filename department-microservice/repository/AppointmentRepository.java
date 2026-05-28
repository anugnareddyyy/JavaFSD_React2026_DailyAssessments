package com.healthcare.repository;

import com.healthcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByStatus(String status);
    List<Appointment> findByPatientId(Integer patientId);
    List<Appointment> findByDoctorId(Integer doctorId);

    // JPQL DML update
    @Modifying
    @Transactional
    @Query("UPDATE Appointment a SET a.status = :status WHERE a.id = :id")
    int updateStatus(@Param("id") int id, @Param("status") String status);

    // JPQL DML delete
    @Modifying
    @Transactional
    @Query("DELETE FROM Appointment a WHERE a.status = :status")
    int deleteByStatus(@Param("status") String status);

    // Native SQL
    @Query(value = "SELECT * FROM appointments WHERE status = :status", nativeQuery = true)
    List<Appointment> findByStatusNative(@Param("status") String status);
}
