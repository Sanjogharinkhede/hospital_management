package com.project.hospital_management.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.dao.BranchDao;
import com.project.hospital_management.dao.EncounterDao;
import com.project.hospital_management.dao.PersonDao;
import com.project.hospital_management.dto.Branch;
import com.project.hospital_management.dto.Encounter;
import com.project.hospital_management.dto.Person;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class EncounterService {
    @Autowired
    private BranchDao branchDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private EncounterDao dao;

    ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();

    public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(int branchId, int personId, Encounter encounter) {
	Branch branch = branchDao.findBranch(branchId);
	Person person = personDao.findPerson(personId);
	if (branch != null && person != null) {
	    List<Branch> branchs = new ArrayList<Branch>();
	    branchs.add(branch);
	    encounter.setBranchs(branchs);
	    encounter.setPerson(person);
	    structure.setData(dao.saveEncounter(encounter));
	    ;
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setMessage("Encounter is Saved!!!");
	    return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

	} else if (branch == null) {
	    throw new IdNotFoundException("Branch id is not valid!!");
	} else {
	    throw new IdNotFoundException("person id is not valid!!");
	}

    }

    public ResponseEntity<ResponseStructure<Encounter>> findEncounter(int id) {
	Encounter encounter = dao.findEncounter(id);
	if (encounter != null) {
	    structure.setData(encounter);
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setMessage("Encounter Found Successfully");
	    return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
	} else {
	    throw new IdNotFoundException("Encounter does not found");
	}

    }

    public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
	Encounter encounter = dao.findEncounter(id);
	if (encounter != null) {
	    structure.setData(encounter);
	    dao.deleteEncounter(id);
	    structure.setStatus(HttpStatus.OK.value());
	    structure.setMessage("Encounter Found Successfully");
	    return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("Encounter does not found");
	}
    }

    public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter) {

	Encounter dbEncounter =dao.findEncounter(id);
	if(dbEncounter!=null) {
	    encounter.setBranchs(dbEncounter.getBranchs());
	    encounter.setPerson(dbEncounter.getPerson());
	    encounter.setEncounterId(id);
	    structure.setData(dao.saveEncounter(encounter));
	    structure.setMessage("Encounter Updated!!");
	    structure.setStatus(HttpStatus.OK.value());
	    return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
	    }else {
		throw new IdNotFoundException("Encounter Does not found");
	    }
	
    }

}
