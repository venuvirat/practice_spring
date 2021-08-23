package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.exceptions.InvalidCredentialsException;
import com.example.student.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("getStudentById")
	public Student getStudentById(@RequestParam int id) {

		return studentService.getStudentById(id);
	}

	@PostMapping("save")
	public String saveStudent(@RequestBody Student student) {
		try {
			studentService.saveStudent(student);
		} catch (InvalidCredentialsException e) {
			return "Missing Credentails please check and make sure all fields must be filled";
		}
		return "Successfully Inserted";

	}

	@GetMapping("getAllStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@PutMapping("update/{id}")
	public void deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
	}
}
