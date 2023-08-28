package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.dao.CourseRepository;
import com.tutkuince.springboot.advancedjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course;
        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
        } else {
            throw new RuntimeException("Course cannot found with id: " + id);
        }
        return course;
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
