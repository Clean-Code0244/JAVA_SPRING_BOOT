package com.omertursun.crudjpa.service;

import com.omertursun.crudjpa.dao.EmployeeDAO;
import com.omertursun.crudjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }
}
