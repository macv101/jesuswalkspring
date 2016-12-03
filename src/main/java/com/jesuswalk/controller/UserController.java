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

import com.jesuswalk.entity.User;
import com.jesuswalk.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("users")
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "getAllUsers", nickname = "getAllUsers")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> findAll() {
		List<User> ret = service.findAll();

		return new ResponseEntity<List<User>>(ret, HttpStatus.OK);

	}
	
	@ApiOperation(value = "postUsers", nickname = "postUsers")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<List<User>> saveAll(
			@RequestBody List<User> users ) {
		List<User> ret = service.save(users);
				
		return new ResponseEntity<List<User>>(ret, HttpStatus.OK);

	}
	
	
}
