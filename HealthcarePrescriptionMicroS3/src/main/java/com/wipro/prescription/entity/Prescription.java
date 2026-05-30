

package com.wipro.prescription.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String medicineName;
    private String dosage;
    private BigDecimal price;
    private Integer patientId;
    private String disease;
    public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getMedicineName() {return medicineName; }
	public void setMedicineName(String n) { this.medicineName = n;
	}

	public String getDosage() { return dosage; }
	public void setDosage(String d) { this.dosage = d; }
	
	public BigDecimal getPrice() {return price; }
	public void setPrice(BigDecimal p) { this.price = p; }
	
	public Object getPatientId() { return patientId; }
	public void setPatientId(Integer p){
		this.patientId = p;
	}
	public String getDiseases() { return disease; }
	public void setDisease(String d) { this.disease = d; }

    // getters/setters
}
