package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);
    Course findById(int id);
    void deleteById(int id);
    List<Course> findCourseListByInstructorId(int id);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
}
