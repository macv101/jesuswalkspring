package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.entity.user.Staff;

public interface StaffService {

	Staff save(Staff staff);
	Staff findOne(Long id);
	List<Staff> findByDepartment(String department);
	List<Staff> findByCommittee(String committee);
	List<Staff> findAll();
}
