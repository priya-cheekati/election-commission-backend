package com.example.electionCom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.electionCom.entity.Student;
import com.example.electionCom.service.StudentService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/")
public class StudentController {


	@Autowired
	StudentService studentService;
	
	@GetMapping(path = "login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
		System.out.println(username);
		System.out.println(password);
		Student student = null;
		try {
			student = studentService.authenticate(username, password);
		} catch (Exception e) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Invalid USERNAME or PASSWORD");
		}
		
		return ResponseEntity.ok(student);
	}
	
	@GetMapping(path = "students")
    public ResponseEntity<?> listStudents() {
         List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
	
	
	@PostMapping(path = "student")
	public ResponseEntity<?> saveUser(@RequestBody Student student) {
		try {
	         studentService.insertStudent(student);	
		}catch(Exception ex) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body("Invalid Request! Duplciate passport number");
		}
         Student std = studentService.getByPassport(student.getPassportNumber());
         return ResponseEntity.ok(std);
		
		
    }
	
	
}
