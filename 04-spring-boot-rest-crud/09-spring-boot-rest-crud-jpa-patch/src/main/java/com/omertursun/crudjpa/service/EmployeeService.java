package com.omertursun.crudjpa.service;

import com.omertursun.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);

}
