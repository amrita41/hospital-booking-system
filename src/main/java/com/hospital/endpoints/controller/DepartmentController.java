package com.hospital.endpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class DepartmentController {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	
	@GetMapping("/departments")
	List<Department> getDepartments()
	{
		return departmentDao.findAll();
	}
	
	@GetMapping("/departments/{deptId}")
	Department getDepartments(@PathVariable String deptId)
	{
		return departmentDao.getById(Integer.parseInt(deptId));
	}
	
	@PostMapping("/departments")
	Department postDepartment(@RequestBody Department department)
	{
		for(Doctor dr:department.getDoctors())
		{
			dr.setDepartment(department);
		}
		departmentDao.save(department);
		return department;
	}
	
	@PutMapping("/departments/{deptId}/doctors/{doctId}")
	void assignDepartmentToDoctor(
			@PathVariable String deptId,
			@PathVariable String doctId
    )
	{
		Department dept = departmentDao.getById(Integer.parseInt(deptId));
		Doctor doct  = doctorDao.getById(Integer.parseInt(doctId));
		doct.setDepartment(dept);
		dept.getDoctors().add(doct);
        doctorDao.save(doct);	
        departmentDao.save(dept);
	}
	
	@DeleteMapping("/departments/{deptId}")
	void deleteDepartment(@PathVariable String deptId)
     {
		Department d = departmentDao.getById(Integer.parseInt(deptId));
		departmentDao.delete(d);
	}
}
