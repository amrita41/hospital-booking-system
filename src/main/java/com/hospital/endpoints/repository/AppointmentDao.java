package com.hospital.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.endpoints.entity.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

}
