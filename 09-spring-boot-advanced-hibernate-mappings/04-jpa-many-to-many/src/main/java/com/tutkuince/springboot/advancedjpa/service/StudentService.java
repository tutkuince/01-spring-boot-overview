package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.Student;

public interface StudentService {
    Student findStudentAndCoursesByStudentId(int id);
}
