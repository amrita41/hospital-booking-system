package com.hospital.endpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.endpoints.entity.Department;
import com.hospital.endpoints.entity.Patient;
import com.hospital.endpoints.repository.PatientDao;

@RestController
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@GetMapping("/patients")
	List<Patient> getDepartments()
	{
		return patientDao.findAll();
	}
	
	@PostMapping("/patients")
	Patient postPatient(@RequestBody Patient patient)
	{
		patientDao.save(patient);
		return patient;
	}
	
	@DeleteMapping("/patients/{pId}")
	void deletePatient(@PathVariable String pId)
	{
		Patient p = patientDao.getById(Integer.parseInt(pId));
		patientDao.delete(p);
	}

}
