package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.model.LittleBook;
import com.jesuswalk.model.Student;
import com.jesuswalk.repository.LittleBookRepository;

@Service
public class LittleBookImpl implements LittleBookService {

	private final LittleBookRepository repository;
	
	@Autowired
	StudentService studentService;

	@Autowired
	LittleBookImpl(LittleBookRepository repository) {
		this.repository = repository;
	}

	public LittleBook save(LittleBook littlebook) {
		LittleBook ret = repository.save(littlebook); 
		
		if(ret != null) {
			Student student = ret.getStudent();
			
			if(student == null)
				return null;
			
			List<String> littlebooks = student.getLittleBooks();
			littlebooks.add(ret.getId());
			student.setLittleBooks(littlebooks);
			
			if(studentService.save(student) == null) {
				repository.delete(littlebook);
				return null;
			}
		}
		return ret;
	}

	public void delete(LittleBook littlebook) {
		repository.delete(littlebook);
	}

	public List<LittleBook> findAll() {
		return repository.findAll();
	}

	public LittleBook find(String id) {
		return repository.findOne(id);
	}

	public List<LittleBook> findBookByStudent(Student student) {
		return repository.findByStudent(student);
	}

}
