package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.PatientEntity;

public interface PatientRepo extends JpaRepository<PatientEntity, String>{

	public PatientEntity findByPid(String pid);

	public PatientEntity findByEmail(String email);

	public PatientEntity findByEmailAndPwd(String email, String pwd);

}
