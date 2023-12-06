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

import com.project.hospital_management.dto.MedItems;
import com.project.hospital_management.service.MedItemsService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meditems")
public class MedItemsController {
    @Autowired
    private MedItemsService service;
    
    
    
    @ApiOperation(value = "Save MedItems", notes = "This api is used to  save the MedItems into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "MedItems saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided "),
	    @ApiResponse(code = 404, message = "Incorrect MedOrder ID!") })

    
    @PostMapping
    public ResponseEntity<ResponseStructure<MedItems>> saveMedItems( @RequestParam int medOrderId,@Valid @RequestBody MedItems medItems) {
	return service.saveMedItems(medOrderId,medItems); 
    }
    
    @ApiOperation(value = "Find a MedItems with Id", notes = "This api is used to  Find the MedItems.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "MedItems Found Successful"),

	    @ApiResponse(code = 404, message = "MedItems with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    
    @GetMapping
    public ResponseEntity<ResponseStructure<MedItems>> findMedItems(@Valid @RequestParam int id) {
	return service.findMedItems(id);
    }
    
    @ApiOperation(value = "Delete a MedItems", notes = "This api is used to Delete the MedItems.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "MedItems Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "MedItems with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    
    @DeleteMapping
    public ResponseEntity<ResponseStructure<MedItems>> DeleteMedItems(@Valid @RequestParam int id) {
	return service.deleteMedItems(id);
    }
    
    @ApiOperation(value = "Update a MedItems", notes = "This api is used to Update the MedItems.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "MedItems details are updated!!!"),

	    @ApiResponse(code = 404, message = "MedItems with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    @PutMapping
    public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@Valid @RequestParam int id,@Valid @RequestBody MedItems medItems) {
	return service.updateMedItems(id,medItems);
    }
}
