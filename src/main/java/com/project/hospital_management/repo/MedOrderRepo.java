package com.project.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.MedOrder;

public interface MedOrderRepo  extends JpaRepository<MedOrder, Integer>{

}
