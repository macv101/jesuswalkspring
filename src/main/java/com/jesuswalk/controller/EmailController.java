package com.jesuswalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesuswalk.response.EmailResponse;
import com.jesuswalk.service.EmailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("email")
@RequestMapping(value = "email")
public class EmailController {
	
	@Autowired
	private EmailService service;

	@ApiOperation(value = "retrieve/{id}", nickname = "Get Email")
	@RequestMapping(value = "retrieve/{id}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<EmailResponse> getMail(
			@PathVariable Long id) {
		EmailResponse ret = service.getMail(id);

		return new ResponseEntity<EmailResponse>(ret, HttpStatus.OK);

	}
	
}
