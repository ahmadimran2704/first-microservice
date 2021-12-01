package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(TestRequest testRequest) {
        Employee emp=new Employee(testRequest.getEmployeeId(),testRequest.getFirstName()
                ,testRequest.getLastName(),testRequest.getSalary());
        employeeRepository.save(emp);
        return "success";

    }
}
