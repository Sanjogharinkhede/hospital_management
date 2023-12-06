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

import com.project.hospital_management.dto.Address;
import com.project.hospital_management.service.AddressService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;
    
    
    @ApiOperation(value = "Save Address", notes = "This api is used to  save the Address into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Address saved in database"),
    	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    @PostMapping
    public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
	return service.saveAddress(address);
    }
    
    @ApiOperation(value = "Find a Address with Id", notes = "This api is used to  Find the Address.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Address Found Successful"),

    	    @ApiResponse(code = 404, message = "Address with given  Id is Not Found "),
    	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })


    
    
    
    @GetMapping
    public ResponseEntity<ResponseStructure<Address>> findAddress(@Valid @RequestParam int id) {
	return service.findAddress(id);
    }
    
    
    
    @ApiOperation(value = "Update a Address", notes = "This api is used to Update the Address.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Address details are updated!!!"),

    	    @ApiResponse(code = 404, message = "Address with given  Id is Not Found "),
    	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    @PutMapping
    public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @RequestParam int id ,@RequestBody Address address){
	return service.updateAddress(id,address);
    }
    
    
    @ApiOperation(value = "Delete a Address", notes = "This api is used to Delete the Address.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Address Found & Deleted Successful"),

    	    @ApiResponse(code = 404, message = "Address with given  Id is Not Found "),
    	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    
    
    
    @DeleteMapping
    public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam int id) {
	return service.deleteAddress(id);
    }
}
