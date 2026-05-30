package com.wipro.Appointment.dto;

import java.time.LocalDate;
    

public class AppointmentDTO {

    private Integer id;

    private LocalDate appointmentDate;
    private String status;
    private Integer patientId;

    private Object patientDetails;   // from patient service
    private Object prescriptions;    // from prescription service
	public void setPatientDetails(Object patient) {
		// TODO Auto-generated method stub
		
	}
	public void setPrescriptions(Object prescriptions2) {
		// TODO Auto-generated method stub
		
	}
	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}
	public void setAppointmentDate(Object appointmentDate2) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(Object status2) {
		// TODO Auto-generated method stub
		
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getAppointmentDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPatientId() {
		// TODO Auto-generated method stub
		return null;
	}

    // getters/setters
}

