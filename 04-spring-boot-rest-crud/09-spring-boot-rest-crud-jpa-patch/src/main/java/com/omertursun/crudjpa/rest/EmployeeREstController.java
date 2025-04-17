package com.omertursun.crudjpa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.omertursun.crudjpa.dao.EmployeeDAO;
import com.omertursun.crudjpa.entity.Employee;
import com.omertursun.crudjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeREstController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeREstController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
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

    @PatchMapping("employee/patch/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {

        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw  new  RuntimeException("Id not found - " + employeeId);
        }
        if(patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id is  not allowed to update  - ");
        }

        Employee patchedEmployee = apply(patchPayload,employee);
        return employeeService.save(patchedEmployee);

    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {

        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
