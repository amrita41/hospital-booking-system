package com.hospital.endpoints.repository;

import com.hospital.endpoints.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.endpoints.entity.Department;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
