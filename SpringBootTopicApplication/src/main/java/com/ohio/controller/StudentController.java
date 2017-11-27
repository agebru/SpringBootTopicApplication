package com.ohio.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ohio.exception.StudentNotFoundException;
import com.ohio.model.RecordCounter;
import com.ohio.model.Student;
import com.ohio.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getAllStudents();
	}
	
	//using the RecordCounter ==>to count the resulting data
	@GetMapping("/all")
	public RecordCounter getAll_students(){
		return studentService.getAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId")int id) throws StudentNotFoundException {
		return studentService.getStudent(id);
	}
	
	@PutMapping("/students/{studentId}")
	public void updateStudent(@PathVariable("studentId")int id,@RequestBody Student student){
		 studentService.updateStudent(id,student);
	}
	
	
	@PostMapping("/students")
	public void AddStudent(@RequestBody Student student){
		studentService.addStudent(student);
	}

}
