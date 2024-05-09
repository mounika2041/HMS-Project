package com.appointments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointments.entity.DoctorEntity;

public interface DoctorRepo extends JpaRepository<DoctorEntity, String> {

}
