package com.tutkuince.springboot.advancedjpa.dao;

import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
