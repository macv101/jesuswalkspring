package com.jesuswalk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jesuswalk.model.LittleBook;
import com.jesuswalk.model.Student;

public interface LittleBookRepository extends MongoRepository<LittleBook, String> {

	public List<LittleBook> findByStudent(Student student);
}
