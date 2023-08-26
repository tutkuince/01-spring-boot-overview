package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.dao.InstructorDetailRepository;
import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private final InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public InstructorDetail findById(int id) {
        Optional<InstructorDetail> optionalInstructorDetail = instructorDetailRepository.findById(id);
        InstructorDetail instructorDetail = null;
        if (optionalInstructorDetail.isPresent()) {
            instructorDetail = optionalInstructorDetail.get();
        } else {
            throw new RuntimeException("Instructor Detail not found with id: " + id);
        }
        return instructorDetail;
    }

    @Override
    public void deleteById(int id) {
        instructorDetailRepository.deleteById(id);
    }
}
