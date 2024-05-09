package com.appointments.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appointments.entity.AppointmentEntity;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Long> {

}
