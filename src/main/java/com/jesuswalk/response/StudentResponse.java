package com.jesuswalk.response;

import java.util.List;

import com.jesuswalk.entity.Student;

public class StudentResponse {
	
	private String message = "Success";
	private int code = 0;
	private List<Student> students;
	
	public StudentResponse() {}
	
	public StudentResponse(ResponseStatus response) {
		this.message = response.message();
		this.code = response.hashCode();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
