package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value="Student Endpoint controller")
@RestController
@RequestMapping("/swagger/restCall")
public class StudentRESTController {
	
	@ApiOperation(value = "Get all student endpoint")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success call"),
			@ApiResponse(code = 401, message = "user unauthorized"),
			@ApiResponse(code = 403, message = "forbidden data"),
			@ApiResponse(code = 404, message = "resource not found")})
	@GetMapping(value="/allStudent", produces="application/json")
	public List<Student> getAllStudent() {
		
		return Arrays.asList(new Student(100,"Tanmoy Dasgupta", "Dankuni",20000),
				new Student(200, "Sanjoy", "Bellandur",40000));
			
	}

	@ApiOperation(value = "Get Single student endpoint")
	@GetMapping(value="/singleStudent/{Studentid}", produces="application/json")
	public Student getSingleStudent(@PathVariable("Studentid") int Studentid ) {
		
		return new Student(Studentid);
	}
}
