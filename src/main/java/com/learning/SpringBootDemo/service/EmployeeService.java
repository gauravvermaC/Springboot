package com.learning.SpringBootDemo.service;


import com.learning.SpringBootDemo.ResouceNotFoundException;
import com.learning.SpringBootDemo.model.Employee;
import com.learning.SpringBootDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Employee Not Found By Id"));
    }

    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "Id already exists";
        }else{
            employeeRepository.save(employee);
            return "Data saved successfully";
        }
    }


}
