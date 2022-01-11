package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dao.Student;
import com.example.student.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	// to add a new student
	public Student addStudent(Student student) {
		Student studentResp = studentRepo.save(student);
		return studentResp;

	}

	// get Student By Id
	public Optional<Student> getStudentById(Long id) {
		Optional<Student> studentResp = studentRepo.findById(id);
		return studentResp;
	}

	// get All Student
	public List<Student> getAllStudent() {
		List<Student> studentResp = studentRepo.findAll();
		return studentResp;
	}

	public Student modifyStudent(long id, Student student) {
		Optional<Student> studentResp = studentRepo.findById(id);
		
		Student studentData = new Student();
		studentData = studentRepo.findById(id).get();
		studentData.setId(studentData.getId());
		studentData.setName(student.getName());
		studentData.setEmail(student.getEmail());
		studentData.setPhone(student.getPhone());

		studentRepo.save(studentData);
		return studentData;
	}

	public Student deleteStudent(long id) {
		studentRepo.deleteById(id);
		return null ;
	}

}
