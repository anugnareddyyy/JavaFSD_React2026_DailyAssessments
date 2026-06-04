package com.wipro.patient.dto;

public class PatientDTO {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String disease;
	public void setId(Integer id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setEmail(String email) {this.email = email;}
	public void setAge(Integer age) {this.age = age;}
	public void setDisease(String disease) {this.disease = disease;}
	public Integer getId() {return id;}
	public String getName() {return name;}
	public String getEmail() {return email;}
	public Integer getAge() {return age;}
	public String getDisease() {return disease;}
}
