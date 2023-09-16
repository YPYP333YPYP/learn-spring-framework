package com.practice.springboot.learnjpaandhibernate.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByAuthor (String author);
	List<Course> findByName (String name);
}
