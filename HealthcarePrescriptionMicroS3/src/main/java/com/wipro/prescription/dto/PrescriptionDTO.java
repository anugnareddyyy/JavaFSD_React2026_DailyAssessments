

package com.wipro.prescription.dto;

import java.math.BigDecimal;

public class PrescriptionDTO {

    private Integer id;
    private String medicineName;
    private String dosage;
    private BigDecimal price;
    private Object patientId;
    private String disease;
    private Object patientDetails;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getMedicineName() {return medicineName; }
	public void setMedicineName(String medicineName) { this.medicineName = medicineName;
	}

	public String getDosage() { return dosage; }
	public void setDosage(String dosage) { this.dosage = dosage; }
	
	public BigDecimal getPrice() {return price; }
	public void setPrice(BigDecimal price) { this.price = price; }
	
	public Object getPatientId() { return patientId; }
	public void setPatientId(Object patientId){
		this.patientId = patientId;
	}
	public String getDiseases() { return disease; }
	public void setDisease(String disease) { this.disease = disease; }
	
	public Object getPatientDetails() { return patientDetails; }
	public void setPatientDetails(Object patientDetails) {
		this.patientDetails = patientDetails;
	}
}
