package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.entity.user.Counselor;

public interface CounselorService {

	Counselor save(Counselor counselor);
	Counselor findOne(Long id);
	List<Counselor> findByGroupname(String groupname);
	List<Counselor> findByGroupclass(String groupclass);
	List<Counselor> findAll();
}
