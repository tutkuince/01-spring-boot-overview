package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.dao.InstructorRepository;
import com.tutkuince.springboot.advancedjpa.entity.Course;
import com.tutkuince.springboot.advancedjpa.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Transactional
    @Override
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        Instructor instructor = null;
        if (optionalInstructor.isPresent()) {
            instructor = optionalInstructor.get();
        } else {
            throw new RuntimeException("No Instructor found by Id: " + id);
        }
        return instructor;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Instructor instructor = findById(id);

        List<Course> courses = instructor.getCourses();

        // break association of all courses for the instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }
        instructorRepository.deleteById(instructor.getId());
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        return instructorRepository.findInstructorByIdJoinFetch(id);
    }
}
