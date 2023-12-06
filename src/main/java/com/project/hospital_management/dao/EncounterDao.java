package com.project.hospital_management.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management.dto.Encounter;
import com.project.hospital_management.repo.EncounterRepo;

@Repository
public class EncounterDao {
    @Autowired
    private  EncounterRepo repo;
     
     public Encounter saveEncounter(Encounter encounter) {
 	return repo.save(encounter);
     }
     public Encounter findEncounter(int id) {
 	return repo.findById(id).isPresent()?repo.findById(id).get():null;
     }
     public void deleteEncounter(int id) {
 	repo.deleteById(id);
     }
//     public List<Encounter> findEncounterByHospital(Hospital hospital) {
// 	List<Encounter> encounters=repo.findEncounterByHospital(hospital);
// 	return encounters.isEmpty()?null:encounters;
//     }
}
