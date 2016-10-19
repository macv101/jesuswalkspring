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

import com.jesuswalk.entity.Counselor;
import com.jesuswalk.service.CounselorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("user/counselors")
@RequestMapping(value = "user/counselors")
public class CounselorController {

	@Autowired
	private CounselorService service;

	@ApiOperation(value = "createCounselor", nickname = "createCounselor")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Counselor> create(@RequestBody Counselor counselor) {
		Counselor ret = service.save(counselor);

		return new ResponseEntity<Counselor>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "updateCounselor", nickname = "updateCounselor")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Counselor> update(@RequestBody Counselor counselor) {
		Counselor ret = service.save(counselor);

		return new ResponseEntity<Counselor>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getCounselor", nickname = "getCounselor")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Counselor> findOne(@PathVariable("id") Long id) {
		Counselor ret = service.findOne(id);

		return new ResponseEntity<Counselor>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getAllCounselors", nickname = "getAllCounselors")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Counselor>> findAll() {
		List<Counselor> ret = service.findAll();

		return new ResponseEntity<List<Counselor>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStaffsByDepartment", nickname = "getStaffsByDepartment")
	@RequestMapping(value = "/groupname/{groupname}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Counselor>> findByAge(@PathVariable("groupname") String groupname) {
		List<Counselor> ret = service.findByGroupname(groupname);

		return new ResponseEntity<List<Counselor>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "getStaffsByCommittee", nickname = "getStaffsByCommittee")
	@RequestMapping(value = "/groupclass/{groupclass}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Counselor>> findByCommittee(@PathVariable("groupclass") String groupclass) {
		List<Counselor> ret = service.findByGroupclass(groupclass);

		return new ResponseEntity<List<Counselor>>(ret, HttpStatus.OK);

	}
}
