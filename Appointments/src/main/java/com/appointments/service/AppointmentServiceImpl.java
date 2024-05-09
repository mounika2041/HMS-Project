package com.appointments.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointments.entity.AppointmentEntity;
import com.appointments.entity.DoctorEntity;
import com.appointments.repo.AppointmentRepo;
import com.appointments.repo.DoctorRepo;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private DoctorRepo doctorRepo;

	private AtomicInteger idCounter = new AtomicInteger(0);

	@Override
	public String generateUniqueId() {
		int newId = idCounter.incrementAndGet();
		return "DOC" + newId;
	}

	  @Override
	    public AppointmentEntity saveAppointment(AppointmentEntity appointment) {
	        return appointmentRepo.save(appointment);
	    }
}
