package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.Instructor;

public interface InstructorService {

    void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);
    Instructor findInstructorByIdJoinFetch(int id);
}
