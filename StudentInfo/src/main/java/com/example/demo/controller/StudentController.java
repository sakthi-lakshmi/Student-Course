package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.CourseService;

@RestController
public class StudentController {

	
	
	@Autowired
	StudentRepo stdRepo;
	
	@Autowired
	CourseRepo crseRepo;
	
	@Autowired
	CourseService crssrvce;
	
	@PostMapping("/addStd")
	public Student addStudent(@RequestBody Student std) {
		stdRepo.saveAndFlush(std);
		return std;
	}
	
	@PutMapping("/updateStd/{stdId}/{crseId}")
	public String updateStd(@PathVariable Long stdId, @PathVariable Long crseId) {
		Set<Course>  crsSet = new HashSet();
		Student std = stdRepo.findById(stdId).get();
		Course crs = crseRepo.findById(crseId).get();
		crsSet = std.getCourse();
		crsSet.add(crs);
		std.setCourse(crsSet);
		std = crssrvce.updateStdCrse(std);
		return "Updated Successfully";
	}
	
	@GetMapping("/getStds")
	public List getAllStudents() {
		List<Student> stdLst = stdRepo.findAll();
		return stdLst;
	
	}
	
	@DeleteMapping("/deleteStd/{stdId}")
	public String deleteStd(@PathVariable Long stdId) {
		stdRepo.deleteById(stdId);
		return "Deleted Successfully";
		
	}
}
