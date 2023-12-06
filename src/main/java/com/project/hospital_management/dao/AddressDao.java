package com.project.hospital_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.Address;
import com.project.hospital_management.repo.AddressRepo;

@Repository
public class AddressDao {
    @Autowired
    private AddressRepo repo;
    public Address saveAddress(Address address) {
	
	return repo.save(address);
    }
    public Address findAddress(int id) {
	return repo.findById(id).isPresent()?repo.findById(id).get():null;
    }
    public void deleteAddress(int id) {
	
	repo.deleteById(id);
	
    }
}
