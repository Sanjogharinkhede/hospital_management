package com.project.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer>{

}
