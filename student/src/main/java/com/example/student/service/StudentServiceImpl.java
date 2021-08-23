package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.controller.Student;
import com.example.student.dao.StudentDao;
import com.example.student.exceptions.InvalidCredentialsException;
import com.example.student.exceptions.InvalidCredentialsException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	@Override
	public void saveStudent(Student student) throws InvalidCredentialsException {

		if (student.getsName() != null && student.getsId() != 0 && student.getsMarks() != 0
				&& student.getCity() != null) {
			studentDao.saveStudent(student);
		} else {
			throw new InvalidCredentialsException();
		}

	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();

	}

	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteStudentById(id); 
		
	}

}
