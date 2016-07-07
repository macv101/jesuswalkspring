package com.jesuswalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesuswalk.model.Student;
import com.jesuswalk.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
 * RestController
 * - Presentation layer allowing HTTP requests to database
 */

@RestController
@Api("students")
@RequestMapping(value = "students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "createStudent", nickname = "createStudent")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Student", value = "Student object", required = false, dataType = "Student object", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Student.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student ret = studentService.save(student);

		return new ResponseEntity<Student>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getAllStudents", nickname = "getAllStudents")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Student.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Student>> findAll() {
		List<Student> ret = studentService.findAll();

		return new ResponseEntity<List<Student>>(ret, HttpStatus.OK);

	}

}
