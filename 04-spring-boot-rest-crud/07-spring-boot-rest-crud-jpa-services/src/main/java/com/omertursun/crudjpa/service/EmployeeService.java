package com.omertursun.crudjpa.service;

import com.omertursun.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

}
