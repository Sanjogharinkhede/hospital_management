package com.project.hospital_management.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management.Exception.IdNotFoundException;
import com.project.hospital_management.Exception.NameNotFoundException;
import com.project.hospital_management.dao.AddressDao;
import com.project.hospital_management.dao.BranchDao;
import com.project.hospital_management.dao.HospitalDao;
import com.project.hospital_management.dto.Address;
import com.project.hospital_management.dto.Branch;
import com.project.hospital_management.dto.Hospital;
import com.project.hospital_management.util.ResponseStructure;

@Service
public class BranchService {
    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private BranchDao dao;

    ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

    public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospitalId, int addressId, Branch branch) {
	Hospital hospital = hospitalDao.findHospital(hospitalId);
	Address address = addressDao.findAddress(addressId);

	if (hospital != null && address != null) {
	    branch.setAddress(address);
	    branch.setHospital(hospital);
	    structure.setData(dao.saveBranch(branch));
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setMessage("Branch Saved Successfully");
	    return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
	} else if (hospital == null) {
	    throw new IdNotFoundException("Hospital Id is not present!!!");
	} else {
	    throw new IdNotFoundException("Address Id is not present!!!");

	}
    }

    public ResponseEntity<ResponseStructure<Branch>> findBranch(int id) {
	Branch branch = dao.findBranch(id);
	if (branch != null) {
	    structure.setData(branch);
	    structure.setMessage("Branch Founded successfully");
	    structure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND);
	} else {
	    throw new IdNotFoundException("Branch Id is not present!!!");
	}
    }

    public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
	Branch branch = dao.findBranch(id);
	if (branch != null) {
	    dao.deleteBranch(id);
	    structure.setData(branch);
	    structure.setMessage("Branch Deleted successfully");
	    structure.setStatus(HttpStatus.OK.value());
	    return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("Branch Id is not present!!!");
	}
    }

    public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch) {
	Branch dbBranch = dao.findBranch(id);
	if (dbBranch != null) {
	    branch.setAddress(dbBranch.getAddress());
	    branch.setHospital(dbBranch.getHospital());
	    branch.setBranchId(id);
	    structure.setData(dao.saveBranch(branch));
	    structure.setMessage("Branch is Updated Successfully!!");
	    structure.setStatus(HttpStatus.OK.value());

	    return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
	} else {
	    throw new IdNotFoundException("Branch Id is not present!!!");

	}
    }

    public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int hospitalId) {
	Hospital hospital = hospitalDao.findHospital(hospitalId);
	ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<List<Branch>>();
	if (hospital != null) {
	    List<Branch> branchs = dao.findBranchByHospital(hospital);
	    if (branchs != null) {
		responseStructure.setData(branchs);
		responseStructure.setMessage("data found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
	    } else {
		responseStructure.setData(null);
		responseStructure.setMessage("No Branches are there found Successfully");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.NOT_FOUND);
	    }
	} else {
	    throw new IdNotFoundException("Hospital id not found!!");
	}
    }

    public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalName(String hospitalName) {
	List<Hospital> hospitals = hospitalDao.findHospitalByName(hospitalName);
	List<Branch> branchs = new ArrayList<Branch>();

	ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<List<Branch>>();
	if (!hospitals.isEmpty()) {
	    for (Hospital hospital : hospitals) {
		branchs.addAll(dao.findBranchByHospital(hospital));

	    }
	    responseStructure.setData(branchs);
	    responseStructure.setMessage("branches are founded successsfully");
	    responseStructure.setStatus(HttpStatus.FOUND.value());
	    return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
	    
	} else {
	    throw new NameNotFoundException("Hospital not Found");
	}
    }

}
