package com.appointments.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.appointments.entity.AppointmentEntity;
import com.appointments.entity.DoctorEntity;

public interface AppointmentService {

	public AppointmentEntity saveAppointment(AppointmentEntity appointment);

	 public String generateUniqueId();


}
