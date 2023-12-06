package com.project.hospital_management.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.dao.EncounterDao;
import com.project.hospital_management.dao.MedOrderDao;
import com.project.hospital_management.dto.Encounter;
import com.project.hospital_management.dto.MedOrder;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class MedOrderService {
    @Autowired
    private  EncounterDao encounterDao;
    @Autowired
    private MedOrderDao dao;
    
    ResponseStructure<MedOrder>  structure =new ResponseStructure<MedOrder>();
    
    public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder( int encounterId,  MedOrder medOrder) {
	Encounter encounter=encounterDao.findEncounter(encounterId);
	if(encounter!=null) {
	    medOrder.setEncounter(encounter);
	    structure.setData(dao.saveMedOrder(medOrder));
	    structure.setMessage("MedOrder Saved Successfully");
	    structure.setStatus(HttpStatus.CREATED.value());
	    return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
	}else {
	    throw new IdNotFoundException("Please provide valid Encounter ID");
	}
	
    }

    public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder( int id) {
	MedOrder medOrder = dao.findMedOrder(id);
	if (medOrder != null) {
	    structure.setData(medOrder);
	    structure.setMessage("MedOrder Founded successfully");
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.FOUND);
	} else {
	    throw new IdNotFoundException("MedOrder Id is not present!!!");
	}
	
    }

    public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder( int id) {
	MedOrder medOrder = dao.findMedOrder(id);
	if (medOrder != null) {
	    dao.deleteMedOrder(id);
	    structure.setData(medOrder);
	    
	    structure.setMessage("MedOrder Deleted successfully");
	    structure.setStatus(HttpStatus.OK.value());
	    return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("MedOrder Id is not present!!!");
	}
	
    }

    public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder( int id,  MedOrder medOrder) {
	MedOrder dbMedOrder = dao.findMedOrder(id);
	if (dbMedOrder != null) {
	    medOrder.setEncounter(dbMedOrder.getEncounter());
	    
	    medOrder.setOrderId(id);
	    structure.setData(dao.saveMedOrder(medOrder));
	    structure.setMessage("MedOrder is Updated Successfully!!");
	    structure.setStatus(HttpStatus.OK.value());

	    return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("MedOrder Id is not present!!!");

	}
	
    }

}
