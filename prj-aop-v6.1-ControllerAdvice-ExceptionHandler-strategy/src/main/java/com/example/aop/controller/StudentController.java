package com.example.aop.controller;


import com.example.aop.aspect.Authentification;
import com.example.aop.exception.ApiException;
import com.example.aop.exception.ApiRequestException;
import com.example.aop.model.Note;
import com.example.aop.model.Student;
import com.example.aop.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/*
 *  https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
 */


@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService studentService;

	@Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {

	    //throw new IllegalStateException("Oops cannot get all student");
        throw new ApiRequestException("Oops cannot get all student");

	}
	
	
	@PostMapping
    public void addNewStudent( @RequestBody Student student ) {
    }
	
}
