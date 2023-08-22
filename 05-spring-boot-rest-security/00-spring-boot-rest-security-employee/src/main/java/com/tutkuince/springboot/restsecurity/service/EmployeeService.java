package com.tutkuince.springboot.restsecurity.service;

import com.tutkuince.springboot.restsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
