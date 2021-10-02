package com.hospital.endpoints.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doctor {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer doctId;
   private String doctName;
   
   @ManyToOne
   //@ManyToOne(cascade = CascadeType.ALL)
   //@JoinColumn(name = "departmentId", referencedColumnName = "deptId")
   private Department department;
  
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
//	public Doctor(Integer doctId, String doctName) {
//			super();
//			this.doctId = doctId;
//			this.doctName = doctName;
//			
//	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Integer doctId, String doctName, Department department) {
	super();
	this.doctId = doctId;
	this.doctName = doctName;
	this.department = department;
}
	public Integer getDoctId() {
		return doctId;
	}
	public void setDoctId(Integer doctId) {
		this.doctId = doctId;
	}
	public String getDoctName() {
		return doctName;
	}
	public void setDoctName(String doctName) {
		this.doctName = doctName;
	}
	@Override
	public String toString() {
		return "Doctor [doctId=" + doctId + ", doctName=" + doctName + "]";
	}
	public void assignDepartment(Department dept) {
		// TODO Auto-generated method stub
		this.department=dept;
	}
}
