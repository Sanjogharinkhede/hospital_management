package com.project.hospital_management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.Hospital;
import com.project.hospital_management.repo.HospitalRepo;

@Repository
public class HospitalDao {
    @Autowired
    private HospitalRepo repo;
    public Hospital saveHospital(Hospital hospital) {
	
	return repo.save(hospital);
    }
    public Hospital findHospital(int id) {
	return repo.findById(id).isPresent()?repo.findById(id).get():null;
    }
    public void deleteHospital(int id) {
	
	repo.deleteById(id);
	
    }
    public List<Hospital> findHospitalByName(String name) {

	return repo.findHospitalByName(name);
    }
}
