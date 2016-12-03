package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.entity.user.Staff;
import com.jesuswalk.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

	private final StaffRepository repository;

	@Autowired
	StaffServiceImpl(StaffRepository repository) {
		this.repository = repository;
	}

	public Staff save(Staff staff) {
		staff.prePersist();
		return repository.save(staff);
	}

	public Staff findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Staff> findByDepartment(String department) {
		return repository.findByDepartment(department);
	}

	public List<Staff> findByCommittee(String committee) {
		return repository.findByCommittee(committee);
	}

	public List<Staff> findAll() {
		return (List<Staff>) repository.findAll();
	}

}
