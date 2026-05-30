package com.wipro.patient.entity;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private int age;
    private String disease;
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDisease() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}
	public void setAge(Object age2) {
		// TODO Auto-generated method stub
		
	}
	public void setDisease(Object disease2) {
		// TODO Auto-generated method stub
		
	}
}
