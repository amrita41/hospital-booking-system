package com.hospital.endpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.endpoints.entity.Appointment;
import com.hospital.endpoints.repository.AppointmentDao;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@GetMapping("/appointments")
	List<Appointment> getAppointments()
	{
		return appointmentDao.findAll();
	}
	
	@PostMapping("/appointments")
	Appointment postAppointment(@RequestBody Appointment appointment)
	{
		appointmentDao.save(appointment);
		return appointment;
	}

}
