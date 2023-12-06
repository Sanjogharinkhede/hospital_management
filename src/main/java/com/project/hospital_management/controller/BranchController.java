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

import com.project.hospital_management.dto.Branch;
import com.project.hospital_management.service.BranchService;
import com.project.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService service;

    @ApiOperation(value = "Save Branch", notes = "This api is used to  save the Branch into The Database")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Branch saved in database"),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided "),
	    @ApiResponse(code = 404, message = "Incorrect ID For Either Address Or Hospital!") })

    @PostMapping
    public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestParam int hospitalId,
	    @Valid @RequestParam int addressId, @Valid @RequestBody Branch branch) {
	return service.saveBranch(hospitalId, addressId, branch);
    }

    @ApiOperation(value = "Find a Branch with Id", notes = "This api is used to  Find the Branch.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Branch Found Successful"),

	    @ApiResponse(code = 404, message = "Branch with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping
    public ResponseEntity<ResponseStructure<Branch>> findBranch(@Valid @RequestParam int id) {
	return service.findBranch(id);
    }

    @ApiOperation(value = "Delete a Branch", notes = "This api is used to delete the Branch.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Branch Found & Deleted Successful"),

	    @ApiResponse(code = 404, message = "Branch with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @DeleteMapping
    public ResponseEntity<ResponseStructure<Branch>> DeleteBranch(@Valid @RequestParam int id) {
	return service.deleteBranch(id);
    }

    @ApiOperation(value = "Update a Branch", notes = "This api is used to Update the Branch.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Branch details are updated!!!"),

	    @ApiResponse(code = 404, message = "Branch with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @PutMapping
    public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid @RequestParam int id,
	    @Valid @RequestBody Branch branch) {
	return service.updateBranch(id, branch);
    }

    @ApiOperation(value = "Find Branchs with Hospital Id", notes = "This api is used to  Find the list of  Branchs with The Hospital ID.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Branchs Founded Successfully"),

	    @ApiResponse(code = 404, message = "Branch with given  Id is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping("/hospital")
    public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(@Valid @RequestParam int hospitalId) {
	return service.findBranchByHospitalId(hospitalId);
    }

    @ApiOperation(value = "Find Branchs with Hospital Name", notes = "This api is used to  Find the list of  Branchs with The Hospital Name.")
    @ApiResponses(value = { @ApiResponse(code = 302, message = "Branchs Founded Successfully"),

	    @ApiResponse(code = 404, message = "Branch with given  Name is Not Found "),
	    @ApiResponse(code = 400, message = "Some Required data is Not Provided or wrongly provided ") })

    @GetMapping("/{hospitalName}")
    public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalName(
	    @Valid @PathVariable String hospitalName) {
	return service.findBranchByHospitalName(hospitalName);
    }

}
