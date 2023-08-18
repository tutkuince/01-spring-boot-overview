package com.tutkuince.springboot.cruddemo.service;

import com.tutkuince.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
