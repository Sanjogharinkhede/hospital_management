package com.project.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.dao.AddressDao;
import com.project.hospital_management.dto.Address;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class AddressService {
    @Autowired
    private AddressDao dao;
    ResponseStructure<Address> structure = new ResponseStructure<Address>();

    public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {

	structure.setMessage("Address saved in database");
	structure.setData(dao.saveAddress(address));
	structure.setStatus(HttpStatus.CREATED.value());

	return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Address>> findAddress(int id) {
	Address address = dao.findAddress(id);
	if (address != null) {
	    structure.setMessage("Address Found Successful");
	    structure.setData(address);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);

	} else {
	    throw new IdNotFoundException("Address id not found -> Please Register first!!!  ");
	}
    }

    public ResponseEntity<ResponseStructure<Address>> updateAddress( int id, Address address) {
	if(dao.findAddress(id)!=null) {
	   structure.setMessage("Address details are updated!!!");
	   structure.setStatus(HttpStatus.OK.value());
	    address.setAddressId(id);
	   structure.setData(dao.saveAddress(address));
	   return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
	   
	}else {
	    throw new IdNotFoundException("Address Id Not Found");
	}
	
    }

    public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
	Address address = dao.findAddress(id);
	if (address != null) {
	    structure.setMessage("Address Found & Deleted Successful");
	    dao.deleteAddress(id);
	    structure.setData(address);
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);

	} else {
	    throw new IdNotFoundException("Address id not found  Please Register first!!!  ");
	}
    }
}
