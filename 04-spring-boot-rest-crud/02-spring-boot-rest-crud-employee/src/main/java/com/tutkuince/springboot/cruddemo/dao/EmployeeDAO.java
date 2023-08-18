package com.tutkuince.springboot.cruddemo.dao;

import com.tutkuince.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
