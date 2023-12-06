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

import com.project.hospital_management.dto.Person;
import com.project.hospital_management.service.PersonService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @ApiOperation(value = "Save Person", notes = "This api is used to  save the person into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Person saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })
    @PostMapping
    public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
	return service.savePerson(person);
    }

    @ApiOperation(value = "Find a Person with Id", notes = "This api is used to  Find the person.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Person Found Successful"),

	    @ApiResponse(code = 404, message = "Person with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping
    public ResponseEntity<ResponseStructure<Person>> findPerson(@Valid @RequestParam int id) {
	return service.findPerson(id);
    }

    @ApiOperation(value = "Update a Person", notes = "This api is used to Update the person.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Person details are updated!!!"),

	    @ApiResponse(code = 404, message = "Person with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @PutMapping
    public ResponseEntity<ResponseStructure<Person>> updatePerson(@Valid @RequestParam int id,
	    @RequestBody Person person) {
	return service.updatePerson(id, person);
    }

    @ApiOperation(value = "Delete a Person", notes = "This api is used to Delete the person.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Person Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "Person with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @DeleteMapping
    public ResponseEntity<ResponseStructure<Person>> deletePerson(@Valid @RequestParam int id) {
	return service.deletePerson(id);
    }

}
