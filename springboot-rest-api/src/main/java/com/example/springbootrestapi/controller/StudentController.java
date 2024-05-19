package com.example.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	//GET Mapping
	//http://localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		
		Student student = new Student(1, "niranjana", "mohan");
		
		//return new ResponseEntity<>(student, HttpStatus.OK);
		return ResponseEntity.ok(student);
		
	}
	
	
	
	// http://localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Niranjana", "Mohan"));
		students.add(new Student(2, "Merlyn", "Chandran"));
		students.add(new Student(3, "Nickesh", "Kumar"));
		students.add(new Student(4, "Avinash", "Vijayan"));
		return students;
	}
	
	//Path variable
	
	// http://localhost:8080/students/2
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId,
			                           @PathVariable("first-name") String firstName,
			                           @PathVariable("last-name") String lastName) 
	{
		return new Student(studentId,firstName, lastName);
		
	}
	
	//Request Param
	// http://localhost:8080/students/query?id=1
	@GetMapping("students/query")
	public Student studentRequestParam(@RequestParam int id) {
		
		return new Student(id, "Nira", "mohan");
	}
	
	//PostMapping and Request body
	//
	
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		
		return student;
	}
	
	//PutMapping
	
	@PutMapping("students/{id}/update")
		public Student updateStudent(@RequestBody Student student , @PathVariable("id") int studentId) {
		
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		
		return student;
	}
	
	//Delete Mapping
	@DeleteMapping("students/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		
		System.out.println(studentId);
		
		return "Student deleted successfully!";
	}

}
