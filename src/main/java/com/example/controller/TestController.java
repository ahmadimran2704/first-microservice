package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeGetDataService;
import com.example.service.EmployeeService;
import com.example.request.TestRequest;
import com.example.response.TestResponse;
import com.example.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("test/v1")
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private EmployeeGetDataService employeeGetDataService;

    private static final Logger log= LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "greeting",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "API to get greetings")
    public TestResponse getGreeting() {
        log.info("Request received at "+ LocalDateTime.now());
        return new TestResponse("hello world",0);
    }

    @PostMapping(value = "employee/save")
    public TestResponse saveEmployee(@RequestBody TestRequest testRequest) {
        log.info("Request received for employee/save at "+ LocalDateTime.now());
        TestResponse response=new TestResponse();
        response.setValue( employeeService.saveEmployee(testRequest));
        return response;
    }

    @GetMapping(value = "employee/get")
    @ApiOperation(value = "API to fetch employee from server")
    public  TestRequest getEmployee() {
        TestRequest response=new TestRequest();
        Employee employee=employeeGetDataService.fetchData(1);
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setSalary(employee.getSalary());
        return response;
    }

    @GetMapping(value = "call-service")
    public TestResponse callService2() {
        TestResponse response=new TestResponse();
        log.info("received request in service 1 to call service 2");
        response.setValue(messageService.callService());
        return response;
    }
}
