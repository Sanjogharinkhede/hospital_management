package com.project.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.Encounter;


public interface EncounterRepo  extends JpaRepository<Encounter, Integer>{

}
