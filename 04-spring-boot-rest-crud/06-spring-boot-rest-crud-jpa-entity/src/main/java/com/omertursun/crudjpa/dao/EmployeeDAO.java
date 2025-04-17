package com.omertursun.crudjpa.dao;

import com.omertursun.crudjpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
