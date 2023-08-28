package com.tutkuince.springboot.advancedjpa.dao;

import com.tutkuince.springboot.advancedjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = ?1")
    Student findStudentAndCoursesByStudentId(int id);
}
