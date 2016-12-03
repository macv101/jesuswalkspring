package com.jesuswalk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesuswalk.entity.finance.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findByYear(String year);
	List<Expense> findByYearAndAccountcode_Code(String year, Long code);
	List<Expense> findByYearAndAccountcode_Department(String year, String department);
	List<Expense> findByYearAndAccountcode_DepartmentAndAccountcode_Committee(String year, String department, String Committee);
	
}
