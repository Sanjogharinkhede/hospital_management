package com.project.hospital_management.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.dao.MedOrderDao;
import com.project.hospital_management.dao.MedItemsDao;
import com.project.hospital_management.dto.MedOrder;
import com.project.hospital_management.dto.MedItems;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class MedItemsService {
    @Autowired
    private MedOrderDao medOrderDao;
    @Autowired
    private MedItemsDao dao;
    ResponseStructure<MedItems>  structure =new ResponseStructure<MedItems>();
    public ResponseEntity<ResponseStructure<MedItems>> saveMedItems( int medOrderId,  MedItems medItems) {
	MedOrder medOrder=medOrderDao.findMedOrder(medOrderId);
	if(medOrder!=null) {
	    medItems.setOrder(medOrder);
	    structure.setData(dao.saveMedItems(medItems));
	    structure.setMessage("MedItems Saved Successfully");
	    structure.setStatus(HttpStatus.CREATED.value());
	    return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
	}else {
	    throw new IdNotFoundException("Please provide valid MedOrder ID");
	}
    }

    public ResponseEntity<ResponseStructure<MedItems>> findMedItems( int id) {
	MedItems medItems = dao.findMedItems(id);
	if (medItems != null) {
	    structure.setData(medItems);
	    structure.setMessage("MedItems Found successfully");
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.FOUND);
	} else {
	    throw new IdNotFoundException("MedItems Id is not present!!!");
	}
    }

    public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems( int id) {
	MedItems medItems = dao.findMedItems(id);
	if (medItems != null) {
	    dao.deleteMedItems(id);
	    structure.setData(medItems);
	    structure.setMessage("MedItems Deleted successfully");
	    structure.setStatus(HttpStatus.OK.value());
	    return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("MedItems Id is not present!!!");
	}
    }
    

    public ResponseEntity<ResponseStructure<MedItems>> updateMedItems( int id,  MedItems medItems) {
	MedItems dbMedItems = dao.findMedItems(id);
	if (dbMedItems != null) {
	    medItems.setOrder(dbMedItems.getOrder());
	    
	    medItems.setItemId(id);
	    structure.setData(dao.saveMedItems(medItems));
	    structure.setMessage("MedItems is Updated Successfully!!");
	    structure.setStatus(HttpStatus.OK.value());

	    return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("MedItems Id is not present!!!");

	}
    }

}
