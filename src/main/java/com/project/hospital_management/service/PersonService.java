package com.project.hospital_management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.dao.PersonDao;
import com.project.hospital_management.dto.Person;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class PersonService {
    @Autowired
    private PersonDao dao;
    ResponseStructure<Person> structure = new ResponseStructure<Person>();

    public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {

	structure.setMessage("Person saved in database");
	structure.setData(dao.savePerson(person));
	structure.setStatus(HttpStatus.CREATED.value());

	return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Person>> findPerson(int id) {
	Person person = dao.findPerson(id);
	if (person != null) {
	    structure.setMessage("Person Found Successful");
	    structure.setData(person);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);

	} else {
	    throw new IdNotFoundException("Person id not found -> Please Register first!!!  ");
	}
    }

    public ResponseEntity<ResponseStructure<Person>> updatePerson( int id, Person person) {
	if(dao.findPerson(id)!=null) {
	   structure.setMessage("Person details are updated!!!");
	   structure.setStatus(HttpStatus.OK.value());
	    person.setPersonId(id);
	   structure.setData(dao.savePerson(person));
	   return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);
	   
	}else {
	    throw new IdNotFoundException("Person Id Not Found");
	}
	
    }

    public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
	Person person = dao.findPerson(id);
	if (person != null) {
	    structure.setMessage("Person Found & Deleted Successful");
	    dao.deletePerson(id);
	    structure.setData(person);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);

	} else {
	    throw new IdNotFoundException("Person id not found  Please Register first!!!  ");
	}
    }

}
