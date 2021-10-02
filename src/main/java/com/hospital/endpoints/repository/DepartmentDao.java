package com.hospital.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.endpoints.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
