package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.Course;

public interface CourseService {

    void save(Course course);
    Course findById(int id);
    void deleteById(int id);
}
