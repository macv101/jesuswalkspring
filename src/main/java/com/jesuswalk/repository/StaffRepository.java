package com.jesuswalk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesuswalk.entity.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{

	List<Staff> findByDepartment(String department);
	List<Staff> findByCommittee(String committee);
	
}
