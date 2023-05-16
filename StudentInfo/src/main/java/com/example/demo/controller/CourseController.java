package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.model.CustomResponse;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {
	@Value(value = "${spring.datasource.url}")
	private String dbUrl;  
		
	@Autowired
	CourseRepo crsRepo;
	
	@Autowired
	CourseService crseSrvce;
	
	@Autowired
    CustomResponse custResp;
	
	@GetMapping("/welcome")
	public String index() {
		return "Welcome to Spring Sample Project "+dbUrl;
	}
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course){
		crsRepo.saveAndFlush(course);
		return course;
	}
	
	@GetMapping("/getCourses")
	public List getCourse() {
		List crseLst = crsRepo.findAll();
		return crseLst;
	}
	
	@PutMapping("/updCourse/{id}")
	public Course updateCrse(@PathVariable Long id,@RequestParam String name) {
		Course crse = crsRepo.findById(id).get();
		crse.setCourseName(name);
;		crsRepo.save(crse);
		return crse;
	}
	
	@DeleteMapping("/deleteCrse")
	public String deleteCrse(@RequestParam Long id) {
		crsRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/chkExcep/{custId}")
	public ResponseEntity<CustomResponse> checkExcep(@PathVariable Long custId){
		if(custId==2) {
			throw new IllegalArgumentException();
		}
		return new ResponseEntity<CustomResponse>(custResp,HttpStatus.OK);
		
	}
}
