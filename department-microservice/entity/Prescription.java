package com.healthcare.entity;

import javax.persistence.*;
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
    public void setPatient(Patient patient) { this.patient = patient; }
}
