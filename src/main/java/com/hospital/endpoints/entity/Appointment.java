package com.hospital.endpoints.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Appointment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointId;
	private Timestamp startTime;
	private Timestamp endTime;
	public Appointment(Integer appointId, Timestamp startTime, Timestamp endTime) {
		super();
		this.appointId = appointId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAppointId() {
		return appointId;
	}
	public void setAppointId(Integer appointId) {
		this.appointId = appointId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
}
