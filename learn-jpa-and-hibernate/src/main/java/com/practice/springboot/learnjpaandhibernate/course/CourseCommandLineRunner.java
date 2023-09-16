package com.practice.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.springboot.learnjpaandhibernate.course.Course;
import com.practice.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.practice.springboot.learnjpaandhibernate.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "practice"));
		repository.save(new Course(2, "Learn GDC", "practice"));
		repository.save(new Course(3, "Learn Azure", "practice"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("practice"));
		System.out.println(repository.findByName("Learn AWS"));


		
	}
	
	
}
