package com.tutkuince.springrest.rest;

import com.tutkuince.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data. . . only once!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Tutku", "Ince"));
        theStudents.add(new Student("Utku", "Ince"));
        theStudents.add(new Student("Mary", "Sniper"));
    }

    // define end point for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
}
