package com.project.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management.dto.Person;

public interface PersonRepo  extends JpaRepository<Person, Integer>{

}
