package com.tutkuince.springboot.cruddemo.dao;

import com.tutkuince.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();
}
