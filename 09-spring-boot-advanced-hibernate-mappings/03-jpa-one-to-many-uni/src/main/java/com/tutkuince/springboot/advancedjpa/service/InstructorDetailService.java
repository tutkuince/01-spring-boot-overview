package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;

public interface InstructorDetailService {

    void save(InstructorDetail instructorDetail);
    InstructorDetail findById(int id);
    void deleteById(int id);
}
