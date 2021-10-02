package com.hospital.endpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/department")
	Department postDepartment(@RequestBody Department department)
	{
		departmentDao.save(department);
		return department;
	}
	@PutMapping("/department/{id}")
	Department updateDepartment(@PathVariable Integer id, @RequestBody Department department)
	{
		Department oldDepartment = departmentDao.getById(id);
		oldDepartment.setDeptName(department.getDeptName());
		return departmentDao.save(oldDepartment);
	}
	@DeleteMapping("/department/{id}")
	ResponseEntity deleteDepartment(@PathVariable Integer id)
	{
		departmentDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
