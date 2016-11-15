package com.jesuswalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesuswalk.entity.Expense;
import com.jesuswalk.service.ExpenseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("finance/expenses")
@RequestMapping(value = "finance/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService service;

	@ApiOperation(value = "createExpense", nickname = "createExpense")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Expense> create(@RequestBody Expense expense) {
		Expense ret = service.save(expense);

		return new ResponseEntity<Expense>(ret, HttpStatus.OK);

	}
}
