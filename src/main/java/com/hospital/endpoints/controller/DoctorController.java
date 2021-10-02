package com.hospital.endpoints.controller;

import com.hospital.endpoints.entity.Doctor;
import com.hospital.endpoints.entity.DoctorResponse;
import com.hospital.endpoints.repository.DepartmentDao;
import com.hospital.endpoints.repository.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorDao doctorDao;

	
	@GetMapping("/doctor")
	List<DoctorResponse> getDoctors()
	{
		return doctorDao.getAllDoctors();
	}

	@GetMapping("/doctor/{deptId}")
	List<Doctor> getDoctorsByDepartment(@PathVariable Integer deptId)
	{
		return doctorDao.getDoctorsByDepartment(deptId);
	}
	@PostMapping("/doctor")
	Doctor addDoctor(@RequestBody Doctor doctor)
	{
		return doctorDao.save(doctor);
	}
	@PutMapping ("/doctor/{id}")
	Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor doctor)
	{
		Doctor oldDoctor = doctorDao.getById(id);
		oldDoctor.setDeptId(doctor.getDeptId());
		return doctorDao.save(oldDoctor);
	}

}
