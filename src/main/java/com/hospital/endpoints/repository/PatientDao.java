package com.hospital.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.endpoints.entity.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{

}
