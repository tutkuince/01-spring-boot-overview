package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.dao.CourseRepository;
import com.tutkuince.springboot.advancedjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findCourseListByInstructorId(int id) {
        return courseRepository.findCoursesByInstructorId(id);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        return courseRepository.findCourseAndReviewsByCourseId(id);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        return courseRepository.findCourseAndStudentsByCourseId(id);
    }
}
