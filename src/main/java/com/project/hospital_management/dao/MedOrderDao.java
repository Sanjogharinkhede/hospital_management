package com.project.hospital_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.MedOrder;
import com.project.hospital_management.repo.MedOrderRepo;

@Repository
public class MedOrderDao {

    @Autowired
    private  MedOrderRepo repo;
     
     public MedOrder saveMedOrder(MedOrder medOrder) {
 	return repo.save(medOrder);
     }
     public MedOrder findMedOrder(int id) {
 	return repo.findById(id).isPresent()?repo.findById(id).get():null;
     }
     public void deleteMedOrder(int id) {
 	repo.deleteById(id);
     }
}
