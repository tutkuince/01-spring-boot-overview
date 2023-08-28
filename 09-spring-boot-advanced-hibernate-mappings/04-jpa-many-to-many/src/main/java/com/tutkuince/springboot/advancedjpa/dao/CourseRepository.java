package com.tutkuince.springboot.advancedjpa.dao;

import com.tutkuince.springboot.advancedjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCoursesByInstructorId(int id);
    @Query("SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = ?1")
    Course findCourseAndReviewsByCourseId(int id);
    @Query("SELECT c FROM Course c JOIN FETCH c.students WHERE c.id = ?1")
    Course findCourseAndStudentsByCourseId(int id);
}
