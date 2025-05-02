package com.omertursun.jwt.controller.impl;


import com.omertursun.jwt.controller.IRestEmployeeController;
import com.omertursun.jwt.dto.DtoEmployee;
import com.omertursun.jwt.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class RestEmployeeControllerImpl implements IRestEmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    public RestEmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    @Override
    public DtoEmployee findEmployeeById(@Valid @PathVariable(value = "id") Long employeeId) {
        return employeeService.findEmployeeById(employeeId);

    }
}
