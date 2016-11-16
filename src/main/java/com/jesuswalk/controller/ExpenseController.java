package com.jesuswalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@ApiOperation(value = "saveExpense", nickname = "saveExpense")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Expense> save(@RequestBody Expense expense) {

		service.save(expense);

		return new ResponseEntity<Expense>(HttpStatus.OK);

	}

	@ApiOperation(value = "getAllExpenses", nickname = "getAllExpenses")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Expense>> getAll() {
		List<Expense> ret = service.findAll();

		return new ResponseEntity<List<Expense>>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getExpensesWithCode", nickname = "getExpensesWithCode")
	@RequestMapping(value = "/{year}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Expense>> getByAccountCode(@PathVariable String year,
			@RequestParam(required = false) Long code) {

		List<Expense> ret = null;

		if (code != null)
			ret = service.findByYearAndAccountCode(year, code);
		else
			ret = service.findByYear(year);
		;

		return new ResponseEntity<List<Expense>>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getExpensesByDepartment", nickname = "getExpensesByDepartment")
	@RequestMapping(value = "/{year}/{department}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Expense>> getByDepartment(@PathVariable String year, @PathVariable String department) {

		List<Expense> ret = service.findByYearAndDepartment(year, department);

		return new ResponseEntity<List<Expense>>(ret, HttpStatus.OK);

	}

	@ApiOperation(value = "getExpensesByCommittee", nickname = "getExpensesByCommittee")
	@RequestMapping(value = "/{year}/{department}/{committee}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Expense>> getByCommittee(@PathVariable String year, @PathVariable String department,
			@PathVariable String committee) {

		List<Expense> ret = service.findByYearAndCommittee(year, department, committee);

		return new ResponseEntity<List<Expense>>(ret, HttpStatus.OK);

	}

}
