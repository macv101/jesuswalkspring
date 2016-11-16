package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.entity.Expense;

public interface ExpenseService {
	
	void save(Expense expense);
	List<Expense> findAll();
	
	List<Expense> findByYear(String year);
	List<Expense> findByYearAndAccountCode(String year, Long code);
	List<Expense> findByYearAndDepartment(String year, String department);
	List<Expense> findByYearAndCommittee(String year, String department, String Committee);
}
