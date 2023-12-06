package com.project.hospital_management.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.Exception.NameNotFoundException;
import com.project.hospital_management.dao.HospitalDao;
import com.project.hospital_management.dto.Hospital;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class HospitalService {
    @Autowired
    private HospitalDao dao;
    ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

    public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

	structure.setMessage("Hospital saved in database");
	structure.setData(dao.saveHospital(hospital));
	structure.setStatus(HttpStatus.CREATED.value());

	return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Hospital>> findHospital(int id) {
	Hospital hospital = dao.findHospital(id);
	if (hospital != null) {
	    structure.setMessage("Hospital Found Successful");
	    structure.setData(hospital);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);

	} else {
	    throw new IdNotFoundException("Hospital id not found -> Please Register first!!!  ");
	}
    }

    public ResponseEntity<ResponseStructure<Hospital>> updateHospital( int id, Hospital hospital) {
	if(dao.findHospital(id)!=null) {
	   structure.setMessage("Hospital details are updated!!!");
	   structure.setStatus(HttpStatus.OK.value());
	    hospital.setHospitalId(id);
	   structure.setData(dao.saveHospital(hospital));
	   return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
	   
	}else {
	    throw new IdNotFoundException("Hospital Id Not Found");
	}
	
    }

    public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
	Hospital hospital = dao.findHospital(id);
	if (hospital != null) {
	    structure.setMessage("Hospital Found & Deleted Successful");
	    dao.deleteHospital(id);
	    structure.setData(hospital);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);

	} else {
	    throw new IdNotFoundException("Hospital id not found  Please Register first!!!  ");
	}
    }

    public ResponseEntity<ResponseStructure<List<Hospital>>> findHospitalByName(String name) {
	List<Hospital> hospitals=dao.findHospitalByName(name);
	ResponseStructure<List<Hospital>> responseStructure=new ResponseStructure<List<Hospital>>();
	if (! hospitals.isEmpty()) {
	    responseStructure.setData(hospitals);
	    responseStructure.setMessage("Hospital Founded Successfully!!");
	    responseStructure.setStatus(HttpStatus.FOUND.value());
	    
	    return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure, HttpStatus.FOUND);
	}else {
	    throw new NameNotFoundException("Hospital Not Found Exception");
	}
	
	
    }
}
