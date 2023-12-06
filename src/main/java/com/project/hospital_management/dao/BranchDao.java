package com.project.hospital_management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.Branch;
import com.project.hospital_management.dto.Hospital;
import com.project.hospital_management.repo.BranchRepo;

@Repository
public class BranchDao {
@Autowired
   private  BranchRepo repo;
    
    public Branch saveBranch(Branch branch) {
	return repo.save(branch);
    }
    public Branch findBranch(int id) {
	return repo.findById(id).isPresent()?repo.findById(id).get():null;
    }
    public void deleteBranch(int id) {
	repo.deleteById(id);
    }
    public List<Branch> findBranchByHospital(Hospital hospital) {
	List<Branch> branchs=repo.findBranchByHospital(hospital);
	return branchs.isEmpty()?null:branchs;
    }
    

}
