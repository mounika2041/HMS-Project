package com.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.entity.AppointmentEntity;
import com.appointments.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/save")
	public AppointmentEntity saveAppointment(@RequestBody AppointmentEntity appointment) {
		return appointmentService.saveAppointment(appointment);
	}

}
