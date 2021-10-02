package com.hospital.endpoints.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;
	private String deptName;
	
	
	//@JsonIgnore
	@OneToMany(mappedBy = "department")
	private Set<Doctor> doctors = new HashSet<>();
	
	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
