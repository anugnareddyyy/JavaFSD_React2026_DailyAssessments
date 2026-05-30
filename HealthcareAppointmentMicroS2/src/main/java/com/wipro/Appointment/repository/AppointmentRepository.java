package com.wipro.Appointment.repository;
import com.wipro.Appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> findByPatientId(Integer patientId); // for cross connection
}


