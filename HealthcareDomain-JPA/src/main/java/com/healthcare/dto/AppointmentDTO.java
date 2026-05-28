package com.healthcare.dto;

import java.time.LocalDate;

public class AppointmentDTO {

    private Integer id;
    private LocalDate appointmentDate;
    private String status;

    // Only expose IDs and names (not full nested objects)
    private Integer patientId;
    private String patientName;
    private Integer doctorId;
    private String doctorName;

    public AppointmentDTO() {}

    public AppointmentDTO(Integer id, LocalDate appointmentDate, String status,
                          Integer patientId, String patientName,
                          Integer doctorId, String doctorName) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getPatientId() { return patientId; }
    public void setPatientId(Integer patientId) { this.patientId = patientId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Integer getDoctorId() { return doctorId; }
    public void setDoctorId(Integer doctorId) { this.doctorId = doctorId; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
}
