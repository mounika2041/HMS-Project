package com.doctor.utility;

import org.springframework.stereotype.Component;

import com.doctor.entity.DoctorEntity;

@Component
public class LoginResponse {

	private String url;
	private DoctorEntity doctor;

	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(String url, DoctorEntity doctor) {
		super();
		this.url = url;
		this.doctor = doctor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

}
