package com.omertursun.crudjpa.rest;

import com.omertursun.crudjpa.dao.EmployeeDAO;
import com.omertursun.crudjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeREstController {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeREstController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
