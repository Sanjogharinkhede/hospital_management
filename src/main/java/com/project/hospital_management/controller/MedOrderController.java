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

import com.project.hospital_management.dto.MedOrder;
import com.project.hospital_management.service.MedOrderService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
    @Autowired
    private MedOrderService service;
    
    
    @ApiOperation(value = "Save MedOrder", notes = "This api is used to  save the MedOrder into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "MedOrder saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided "),
	    @ApiResponse(code = 404, message = "Incorrect Encounter ID!") })

    
    
    @PostMapping
    public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@Valid @RequestParam int encounterId,@Valid @RequestBody MedOrder medOrder) {
	return service.saveMedOrder(encounterId,medOrder); 
    }
    
    @ApiOperation(value = "Find a MedOrder with Id", notes = "This api is used to  Find the MedOrder.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "MedOrder Found Successful"),

	    @ApiResponse(code = 404, message = "MedOrder with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    @GetMapping
    public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(@Valid @RequestParam int id) {
	return service.findMedOrder(id);
    }
    
    @ApiOperation(value = "Delete a MedOrder", notes = "This api is used to Delete the MedOrder.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "MedOrder Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "MedOrder with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @DeleteMapping
    public ResponseEntity<ResponseStructure<MedOrder>> DeleteMedOrder(@Valid @RequestParam int id) {
	return service.deleteMedOrder(id);
    }
    
    @ApiOperation(value = "Update a MedOrder", notes = "This api is used to Update the MedOrder.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "MedOrder details are updated!!!"),

	    @ApiResponse(code = 404, message = "MedOrder with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    
    @PutMapping
    public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@Valid @RequestParam int id,@Valid @RequestBody MedOrder medOrder) {
	return service.updateMedOrder(id,medOrder);
    }
}
