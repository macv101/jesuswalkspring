package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.entity.Expense;
import com.jesuswalk.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository repository;

	@Autowired
	ExpenseServiceImpl(ExpenseRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Expense save(Expense expense) {
		return repository.save(expense);
	}
	
	@Override
	public List<Expense> findAll() {
		return (List<Expense>) repository.findAll();
	}
	
	@Override
	public List<Expense> findByYear(String year) {
		return repository.findByYear(year);
	}

	@Override
	public List<Expense> findByYearAndAccountCode(String year, Long code) {
		return repository.findByYearAndAccountcode_Code(year, code);
	}

	@Override
	public List<Expense> findByYearAndDepartment(String year, String department) {
		return repository.findByYearAndAccountcode_Department(year, department);
	}

	@Override
	public List<Expense> findByYearAndCommittee(String year, String department, String Committee) {
		return repository.findByYearAndAccountcode_DepartmentAndAccountcode_Committee(year, department, Committee);
	}

}
