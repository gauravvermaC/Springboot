package com.learning.SpringBootDemo.controller;


import com.learning.SpringBootDemo.model.Employee;
import com.learning.SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getemployees(){
       return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Integer Id){
        return employeeService.getEmployee(Id);
    }

    @PostMapping("/employees/add")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }


}
