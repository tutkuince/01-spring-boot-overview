package com.tutkuince.springboot.advancedjpa.dao;

import com.tutkuince.springboot.advancedjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
