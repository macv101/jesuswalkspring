package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.model.LittleBook;
import com.jesuswalk.model.Student;

public interface LittleBookService {

	LittleBook save(LittleBook littlebook);
	void delete(LittleBook littlebook);
	List<LittleBook> findAll();
	LittleBook find(String id);
	List<LittleBook> findBookByStudent(Student student);
	
}
