package com.wipro.Appointment.entity;


	
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	
	    private LocalDate appointmentDate;
	    private String status;
	    private Integer patientId;
		public String getPatientId() {
			// TODO Auto-generated method stub
			return null;
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
		public void setId(Object id2) {
			// TODO Auto-generated method stub
			
		}
		public void setAppointmentDate(Object appointmentDate2) {
			// TODO Auto-generated method stub
			
		}
		public void setStatus(Object status2) {
			// TODO Auto-generated method stub
			
		}
		public void setPatientId(Object patientId2) {
			// TODO Auto-generated method stub
			
		}
	
	    // getters/setters
}
	