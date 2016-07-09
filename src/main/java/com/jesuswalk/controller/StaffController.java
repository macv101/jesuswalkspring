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

import com.jesuswalk.model.Staff;
import com.jesuswalk.service.StaffService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("user/staffs")
@RequestMapping(value = "user/staffs")
public class StaffController {
	
	@Autowired
	private StaffService service;

	@ApiOperation(value = "createStaff", nickname = "createStaff")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Staff> create(@RequestBody Staff staff) {
		Staff ret = service.save(staff);

		return new ResponseEntity<Staff>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "updateStaff", nickname = "updateStaff")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Staff> update(@RequestBody Staff staff) {
		Staff ret = service.save(staff);

		return new ResponseEntity<Staff>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getStaff", nickname = "getStaff")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Staff> findOne(@PathVariable("id") Long id) {
		Staff ret = service.findOne(id);

		return new ResponseEntity<Staff>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getAllStaffs", nickname = "getAllStaffs")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Staff>> findAll() {
		List<Staff> ret = service.findAll();

		return new ResponseEntity<List<Staff>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStaffsByDepartment", nickname = "getStaffsByDepartment")
	@RequestMapping(value = "/department/{department}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Staff>> findByAge(@PathVariable("department") String department) {
		List<Staff> ret = service.findByDepartment(department);

		return new ResponseEntity<List<Staff>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStaffsByCommittee", nickname = "getStaffsByCommittee")
	@RequestMapping(value = "/committee/{committee}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Staff>> findByCommittee(@PathVariable("grade") String committee) {
		List<Staff> ret = service.findByCommittee(committee);

		return new ResponseEntity<List<Staff>>(ret, HttpStatus.OK);

	}
	
}
