package com.tutkuince.springboot.restsecurity.dao;

import com.tutkuince.springboot.restsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
