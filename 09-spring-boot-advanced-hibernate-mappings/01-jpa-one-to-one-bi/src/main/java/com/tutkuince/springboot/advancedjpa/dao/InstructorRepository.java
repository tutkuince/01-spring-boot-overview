package com.tutkuince.springboot.advancedjpa.dao;

import com.tutkuince.springboot.advancedjpa.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
