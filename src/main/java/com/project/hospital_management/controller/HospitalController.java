package com.project.hospital_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_management.dto.Hospital;
import com.project.hospital_management.service.HospitalService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService service;

    @ApiOperation(value = "Save Hospital", notes = "This api is used to  save the Hospital into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Hospital saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @PostMapping
    public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
	return service.saveHospital(hospital);
    }

    @ApiOperation(value = "Find a Hospital with Id", notes = "This api is used to  Find the Hospital.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Hospital Found Successful"),

	    @ApiResponse(code = 404, message = "Hospital with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping
    public ResponseEntity<ResponseStructure<Hospital>> findHospital(@Valid @RequestParam int id) {
	return service.findHospital(id);
    }

    @ApiOperation(value = "Update a Hospital", notes = "This api is used to Update the Hospital.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Hospital details are updated!!!"),

	    @ApiResponse(code = 404, message = "Hospital with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @PutMapping
    public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@Valid @RequestParam int id,
	    @Valid @RequestBody Hospital hospital) {
	return service.updateHospital(id, hospital);
    }

    @ApiOperation(value = "Delete a Hospital", notes = "This api is used to Delete the Hospital.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Hospital Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "Hospital with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @DeleteMapping
    public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@Valid @RequestParam int id) {
	return service.deleteHospital(id);
    }

    @ApiOperation(value = "Find Hospitals with hospital Name", notes = "This api is used to  Find the Hospital With given name.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Hospital Founded Successfully!!"),

	    @ApiResponse(code = 404, message = "Hospitals with given  Name does Not Founded "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping("/{name}")
    public ResponseEntity<ResponseStructure<List<Hospital>>> findHospitalByName(@Valid @PathVariable String name) {
	return service.findHospitalByName(name);
    }
}
