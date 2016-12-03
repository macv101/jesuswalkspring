package com.jesuswalk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesuswalk.entity.user.Counselor;

public interface CounselorRepository extends CrudRepository<Counselor, Long>{

	List<Counselor> findByGroupname(String groupname);
	List<Counselor> findByGroupclass(String groupclass);

}