package com.omertursun.crudjpa.rest;

import com.omertursun.crudjpa.dao.EmployeeDAO;
import com.omertursun.crudjpa.entity.Employee;
import com.omertursun.crudjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeByEmployeeId(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PutMapping("/employees/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/delete/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }


}
