package com.healthcare.dto;

import java.math.BigDecimal;

import com.healthcare.entity.Patient;

public class PrescriptionDTO {

    private Integer id;
    private String medicineName;
    private String dosage;
    private BigDecimal price;

    // Only patient info needed (not full entity)
    private Patient patientId;
    private String patientName;

    public PrescriptionDTO() {}

    public PrescriptionDTO(Integer id, String medicineName, String dosage,
                           BigDecimal price, Patient patientId, String patientName) {
        this.id = id;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.price = price;
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Patient getPatientId() { return patientId; }
    public void setPatientId(Object patient) { this.patientId = patient; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

	public void setDisease(Object disease) {
		// TODO Auto-generated method stub
		
	}
}
