package com.project.hospital_management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

    List<Hospital> findHospitalByName(String name);

}
