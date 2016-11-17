package com.jesuswalk.service;

import java.util.ArrayList;
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
		Expense current = repository.findOne(expense.getId());
		expense = merge(expense, current);
		expense.prePersist();
		return repository.save(expense);
	}
	
	@Override
	public List<Expense> saveAll(List<Expense> expenses) {
		List<Expense> ret = new ArrayList<Expense>();
		
		for(Expense expense : expenses) {
			Expense current = repository.findOne(expense.getId());
			Expense merged = merge(expense, current);
			merged.prePersist();
			ret.add(repository.save(merged));			
		}
		
		return ret;
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
	
	private Expense merge(Expense expense, Expense current) {
		current.setUrl(expense.getUrl() != null ? expense.getUrl(): current.getUrl());
		current.setStaff(expense.getStaff() != null ? expense.getStaff(): current.getStaff());
		current.setVendor(expense.getVendor() != null ? expense.getVendor(): current.getVendor());
		current.setYear(expense.getYear() != null ? expense.getYear(): current.getYear());
		current.setFormofpayment(expense.getFormofpayment() != null ? expense.getFormofpayment(): current.getFormofpayment());
		current.setReimbursed(expense.getReimbursed() != null ? expense.getReimbursed(): current.getReimbursed());
		
		current.setProjecteddate(expense.getProjecteddate() != null ? expense.getProjecteddate(): current.getProjecteddate());
		current.setAccountcode(expense.getAccountcode() != null ? expense.getAccountcode(): current.getAccountcode());
		current.setDescription(expense.getDescription() != null ? expense.getDescription(): current.getDescription());
		current.setProjectedcost(expense.getProjectedcost() != null ? expense.getProjectedcost(): current.getProjectedcost());
		current.setActualcost(expense.getActualcost() != null ? expense.getActualcost(): current.getActualcost());
		current.setDateofpurchase(expense.getDateofpurchase() != null ? expense.getDateofpurchase(): current.getDateofpurchase());
		current.setRemaining(expense.getRemaining() != null ? expense.getRemaining(): current.getRemaining());
		current.setNotes(expense.getNotes() != null ? expense.getNotes(): current.getNotes());
		current.setStatus(expense.getStatus() != null ? expense.getStatus(): current.getStatus());
		
		return current;
	}

}
