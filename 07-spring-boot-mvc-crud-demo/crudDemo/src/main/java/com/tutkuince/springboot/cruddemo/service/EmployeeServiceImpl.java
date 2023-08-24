package com.tutkuince.springboot.cruddemo.service;

import com.tutkuince.springboot.cruddemo.dao.EmployeeRepository;
import com.tutkuince.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee selectedEmployee = null;
        if (optionalEmployee.isPresent()) {
            selectedEmployee = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee cannot be found with this id: " + id);
        }
        return selectedEmployee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
