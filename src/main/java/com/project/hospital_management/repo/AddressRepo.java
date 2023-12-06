package com.project.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
