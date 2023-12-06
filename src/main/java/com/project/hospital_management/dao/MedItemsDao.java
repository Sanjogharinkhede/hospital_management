package com.project.hospital_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.MedItems;
import com.project.hospital_management.repo.MedItemsRepo;

@Repository
public class MedItemsDao {

    @Autowired
    private  MedItemsRepo repo;
     
     public MedItems saveMedItems(MedItems medItems) {
 	return repo.save(medItems);
     }
     public MedItems findMedItems(int id) {
 	return repo.findById(id).isPresent()?repo.findById(id).get():null;
     }
     public void deleteMedItems(int id) {
 	repo.deleteById(id);
     }
}
