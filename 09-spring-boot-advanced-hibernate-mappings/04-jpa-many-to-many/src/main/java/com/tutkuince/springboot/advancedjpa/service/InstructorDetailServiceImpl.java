package com.tutkuince.springboot.advancedjpa.service;

import com.tutkuince.springboot.advancedjpa.dao.InstructorDetailRepository;
import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private final InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    @Transactional
    public void save(InstructorDetail instructorDetail) {
        instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public InstructorDetail findById(int id) {
        Optional<InstructorDetail> optionalInstructorDetail = instructorDetailRepository.findById(id);
        InstructorDetail instructorDetail;
        if (optionalInstructorDetail.isPresent()) {
            instructorDetail = optionalInstructorDetail.get();
        } else {
            throw new RuntimeException("Instructor Detail not found with id: " + id);
        }
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        InstructorDetail instructorDetail = findById(id);

        // remove the associated object reference
        // break bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        instructorDetailRepository.deleteById(id);
    }
}
