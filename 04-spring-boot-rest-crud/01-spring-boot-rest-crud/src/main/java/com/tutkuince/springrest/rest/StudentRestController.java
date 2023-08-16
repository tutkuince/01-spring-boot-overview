package com.tutkuince.springrest.rest;

import com.tutkuince.springrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define end point for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Tutku", "Ince"));
        studentList.add(new Student("Utku", "Ince"));
        studentList.add(new Student("Mary", "Sniper"));

        return studentList;
    }
}
