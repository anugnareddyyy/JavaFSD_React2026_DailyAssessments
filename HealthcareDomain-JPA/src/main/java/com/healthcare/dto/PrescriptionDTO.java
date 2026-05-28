package com.healthcare.dto;

import java.math.BigDecimal;

public class PrescriptionDTO {

    private Integer id;
    private String medicineName;
    private String dosage;
    private BigDecimal price;

    // Only patient info needed (not full entity)
    private Integer patientId;
    private String patientName;

    public PrescriptionDTO() {}

    public PrescriptionDTO(Integer id, String medicineName, String dosage,
                           BigDecimal price, Integer patientId, String patientName) {
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
    public Integer getPatientId() { return patientId; }
    public void setPatientId(Integer patientId) { this.patientId = patientId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
}
