package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.response.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeGetDataService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee fetchData(int employeeId) {
        Employee emp=null;
       Optional<Employee> employee= employeeRepository.findById(employeeId);
       if(employee.isPresent()) {
           emp=  employee.get();
       }
       return emp;
    }
}
