package com.tutkuince.springrest.rest;

import com.tutkuince.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        // check the studentId again list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHanler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
