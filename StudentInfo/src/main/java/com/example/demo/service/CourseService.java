package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;

@Service
public class CourseService {
	
	@Autowired 
	CourseRepo courseRepo;
	
	@Autowired
	StudentRepo stdRepo;

	public Student updateStdCrse(Student std) {
		stdRepo.saveAndFlush(std);
		return std;
		// TODO Auto-generated method stub
		
	}

	

}
