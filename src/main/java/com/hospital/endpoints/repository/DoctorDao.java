package com.hospital.endpoints.repository;

import com.hospital.endpoints.entity.DoctorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.endpoints.entity.Doctor;

import java.util.List;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer>{
    @Query("Select new com.hospital.endpoints.entity.DoctorResponse(do.doctName,de.deptName) from Doctor do INNER JOIN Department de ON do.deptId=de.deptId")
    List<DoctorResponse> getAllDoctors();
    @Query("select d from Doctor d where d.deptId=?1")
    List<Doctor> getDoctorsByDepartment(Integer id);
}
