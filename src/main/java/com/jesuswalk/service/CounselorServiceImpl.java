package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.entity.user.Counselor;
import com.jesuswalk.repository.CounselorRepository;

@Service
public class CounselorServiceImpl implements CounselorService {

	private final CounselorRepository repository;
	
	@Autowired
	CounselorServiceImpl(CounselorRepository repository) {
		this.repository = repository;
	}
	
	public Counselor save(Counselor counselor) {
		counselor.prePersist();
		return repository.save(counselor);
	}

	public Counselor findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Counselor> findByGroupname(String groupname) {
		return repository.findByGroupname(groupname);
	}

	public List<Counselor> findByGroupclass(String groupclass) {
		return repository.findByGroupclass(groupclass);
	}

	public List<Counselor> findAll() {
		return (List<Counselor>) repository.findAll();
	}

}
