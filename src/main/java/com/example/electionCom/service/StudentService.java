package com.example.electionCom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.electionCom.entity.Student;
import com.example.electionCom.repository.StudentJdbcRepository;

@Component
public class StudentService {
	
	@Autowired
    StudentJdbcRepository repository;
	
	public Student getById(long id) {
		Student student = repository.findById(id);
		
		return student;
	}
	
	public Student getByPassport(String number) {
		
		Student student = repository.findByPassport(number);
		return student;
	}

	public List<Student> getAllStudents(){
		
		return repository.findAll();
	}
	
	public void insertStudent(Student student) throws Exception {
//		Student existingStudent = repository.findByPassport(student.getPassportNumber());
//		System.out.println(existingStudent);
//		if(existingStudent != null) {
//			throw new Exception("Student with give passport number exists");
//		}
	    repository.insertPS(student);
	    
	}
	
	public Student authenticate(String username, String password) throws Exception {
		Student existingStudent = repository.findByUsername(username, password);
		if(existingStudent == null) {
			throw new Exception("Invalid username and password");
		}
		
		return existingStudent;

	}
}

