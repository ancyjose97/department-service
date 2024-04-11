package com.cts.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.departmentservice.dto.DepartmentDto;
import com.cts.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "Department Service - DepartmentController",
		description = "Department Controller exposes REST APIs for Department-Service"
		
		)

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	
	@Operation(
			summary = "Save Department REST API",
			description = "Save Department REST API is used to save department object in a database"
			)
	
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		
		
		return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
	}
	
	
	@Operation(
			summary = "Get Department REST API",
			description = "Get Department REST API is used to get a department object from the database"
			)
	
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	
	
	//This method we are calling from employee-service microservice
	@GetMapping("/{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
		
		return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
	}
}
