package com.hospital.endpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class DepartmentController {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	@GetMapping("/departments")
	List<Department> getDepartments()
	{
		return departmentDao.findAll();
	}
	
	@PostMapping("/departments")
	Department postDepartment(@RequestBody Department department)
	{
		departmentDao.save(department);
		return department;
	}
	

}
