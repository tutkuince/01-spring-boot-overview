package com.tutkuince.springboot.cruddemo.service;

import com.tutkuince.springboot.cruddemo.dao.EmployeeDAO;
import com.tutkuince.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
