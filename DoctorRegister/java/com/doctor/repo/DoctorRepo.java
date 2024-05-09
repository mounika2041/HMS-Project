package com.doctor.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.entity.DoctorEntity;

public interface DoctorRepo extends JpaRepository<DoctorEntity, String> {

	public DoctorEntity findByEmail(String email);

	public DoctorEntity findByDocid(String docid);

	public DoctorEntity findByEmailAndPwd(String email, String pwd);



}

