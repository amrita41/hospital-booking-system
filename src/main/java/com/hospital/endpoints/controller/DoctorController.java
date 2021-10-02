package com.hospital.endpoints.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.endpoints.entity.Department;
import com.hospital.endpoints.entity.Doctor;
import com.hospital.endpoints.repository.DepartmentDao;
import com.hospital.endpoints.repository.DoctorDao;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@GetMapping("/doctors")
	List<Doctor> getDoctors()
	{
		return doctorDao.findAll();
	}
	

	@GetMapping("/doctors/{doctId}")
	Doctor getDoctors(@PathVariable String doctId)
	{
		return doctorDao.getById(Integer.parseInt(doctId));
	}
	
	@PostMapping("/doctors")
	Doctor postDoctor(@RequestBody Doctor doctor)
	{
		doctorDao.save(doctor);
		return doctor;
	}
	
	@PutMapping("/doctors/{doctId}/departments/{deptId}")
	void assignDepartmentToDoctor(
			@PathVariable String doctId,
			@PathVariable String deptId
    )
	{
		Department dept = departmentDao.getById(Integer.parseInt(deptId));
		Doctor doct  = doctorDao.getById(Integer.parseInt(doctId));
		doct.setDepartment(dept);
		dept.getDoctors().add(doct);
        doctorDao.save(doct);	
        departmentDao.save(dept);
	}
	
//	@DeleteMapping("/doctors/{doctId}")
//	void deleteDoctor(@PathVariable String doctId)
//	{
//		Doctor d = doctorDao.getById(Integer.parseInt(doctId));
//		doctorDao.delete(d);
//	}
	
}
