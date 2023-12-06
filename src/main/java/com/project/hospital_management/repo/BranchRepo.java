package com.project.hospital_management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.hospital_management.dto.Branch;
import com.project.hospital_management.dto.Hospital;

public interface BranchRepo  extends JpaRepository<Branch, Integer>{

    List<Branch>  findBranchByHospital(Hospital hospital);
}
