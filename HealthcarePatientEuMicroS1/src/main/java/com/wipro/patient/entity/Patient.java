package com.wipro.patient.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private int age;
    private String disease;
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public Integer getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	public String getDisease() {
		// TODO Auto-generated method stub
		return disease;
	}
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		
	}
	public void setAge(Integer age) {
		// TODO Auto-generated method stub
		this.age = age;
		
	}
	public void setDisease(String disease) {
		// TODO Auto-generated method stub
		this.disease =disease;
	}
}
