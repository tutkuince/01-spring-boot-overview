package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.Student;

public interface StudentService {
    Student findStudentAndCoursesByStudentId(int id);
    void save(Student student);
    void deleteStudentById(int id);
}
