package com.example.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dao.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/hello")
	public String helloSpringBoot(){
		System.out.println("Hello Spring Boot");
		return "Hello Spring Boot";
		
	}
	
	//Get List student
	@GetMapping("/getallstudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		System.out.println("Inside Student controller");
		List<Student> studentresp = studentService.getAllStudent();
		System.out.println("Response"+studentresp);
		return ResponseEntity.ok(studentresp);
	}
	
	//Get studentById
	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable long id){
		System.out.println("Inside Student controller"+id);
		Optional<Student> studentresp = null;
		try {
		studentresp = studentService.getStudentById(id);
		System.out.println("Response"+studentresp);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.ok(studentresp);
	}
	
	//Post Student
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		System.out.println("Inside Student controller"+student);
		Student studentresp = studentService.addStudent(student);
		System.out.println("Response"+studentresp);
		return ResponseEntity.ok(studentresp);
	}
	
	//Put StudentById
	@PutMapping("/modifystudent/{id}")
	public ResponseEntity<Student> modifyStudent(@PathVariable long id,@RequestBody Student student){
		System.out.println("Inside Student controller"+id);
		Student studentresp = studentService.modifyStudent(id,student);
		System.out.println("Response"+studentresp);
		return ResponseEntity.ok(studentresp);
	}
	
	//Delete StudentById
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id){
		System.out.println("Inside Student controller"+id);
		Student studentresp = studentService.deleteStudent(id);
		System.out.println("Response"+studentresp);
		return ResponseEntity.ok("Success");
	}

}
