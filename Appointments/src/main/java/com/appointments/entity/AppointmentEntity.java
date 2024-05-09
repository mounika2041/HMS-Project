package com.appointments.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pname;
	private Long mobile;
	private Integer age;
	private String gender;
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private DoctorEntity doctor;
	

	public AppointmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentEntity(Long id, String pname, Long mobile, Integer age, String gender, String email,
			DoctorEntity doctor) {
		super();
		this.id = id;
		this.pname = pname;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

   
	
   
	
    
   
	
}
