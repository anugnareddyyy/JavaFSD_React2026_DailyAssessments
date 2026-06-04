package com.healthcare.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String medicineName;
    private String dosage;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Prescription() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Patient getPatient() { return patient; }
    public void setPatient(Object object) { this.patient = (Patient) object; }

	public Object getDisease() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDisease(Object disease) {
		// TODO Auto-generated method stub
		
	}
}
