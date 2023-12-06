package com.project.hospital_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.Person;
import com.project.hospital_management.repo.PersonRepo;
@Repository
public class PersonDao {

    @Autowired
    private PersonRepo repo;
    public Person savePerson(Person person) {
	
	return repo.save(person);
    }
    public Person findPerson(int id) {
	return repo.findById(id).isPresent()?repo.findById(id).get():null;
    }
    public void deletePerson(int id) {
	
	repo.deleteById(id);
	
    }

}
