package com.project.hospital_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_management.dto.Encounter;
import com.project.hospital_management.service.EncounterService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

    @Autowired
    private EncounterService service;

    @ApiOperation(value = "Save Encounter", notes = "This api is used to  save the Encounter into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Encounter saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided "),
	    @ApiResponse(code = 404, message = "Incorrect ID For Either Person Or Branch!") })

    @PostMapping
    public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestParam int branchId,
	    @Valid @RequestParam int personId, @Valid @RequestBody Encounter encounter) {
	return service.saveEncounter(branchId, personId, encounter);
    }

    @ApiOperation(value = "Find a Encounter with Id", notes = "This api is used to  Find the Encounter.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Encounter Found Successful"),

	    @ApiResponse(code = 404, message = "Encounter with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping
    public ResponseEntity<ResponseStructure<Encounter>> findEncounter(@Valid @RequestParam int id) {
	return service.findEncounter(id);
    }

    @ApiOperation(value = "Delete a Encounter", notes = "This api is used to Delete the Encounter.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Encounter Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "Encounter with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @DeleteMapping
    public ResponseEntity<ResponseStructure<Encounter>> DeleteEncounter(@Valid @RequestParam int id) {
	return service.deleteEncounter(id);
    }

    @ApiOperation(value = "Update a Encounter", notes = "This api is used to Update the Encounter.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Encounter details are updated!!!"),

	    @ApiResponse(code = 404, message = "Encounter with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @PutMapping
    public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@Valid @RequestParam int id,
	    @Valid @RequestBody Encounter encounter) {
	return service.updateEncounter(id, encounter);
    }
}
