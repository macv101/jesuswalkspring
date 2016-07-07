package com.jesuswalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesuswalk.model.Student;
import com.jesuswalk.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student ret = studentService.save(student);

		return new ResponseEntity<Student>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "updateStudent", nickname = "updateStudent")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Student> update(@RequestBody Student student) {
		Student ret = studentService.save(student);

		return new ResponseEntity<Student>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getStudent", nickname = "getStudent")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Student> findOne(@PathVariable("id") Long id) {
		Student ret = studentService.findOne(id);

		return new ResponseEntity<Student>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getAllStudents", nickname = "getAllStudents")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Student>> findAll() {
		List<Student> ret = studentService.findAll();

		return new ResponseEntity<List<Student>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStudentsByAge", nickname = "getStudentsByAge")
	@RequestMapping(value = "/age/{age}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Student>> findByAge(@PathVariable("age") int age) {
		List<Student> ret = studentService.findByAge(age);

		return new ResponseEntity<List<Student>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStudentsByGrade", nickname = "getStudentsByGrade")
	@RequestMapping(value = "/grade/{grade}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Student>> findByGrade(@PathVariable("grade") int grade) {
		List<Student> ret = studentService.findByAge(grade);

		return new ResponseEntity<List<Student>>(ret, HttpStatus.OK);

	}

}
