package com.omertursun.crudjpa.rest;

import com.omertursun.crudjpa.dao.EmployeeDAO;
import com.omertursun.crudjpa.entity.Employee;
import com.omertursun.crudjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeREstController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeREstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}
