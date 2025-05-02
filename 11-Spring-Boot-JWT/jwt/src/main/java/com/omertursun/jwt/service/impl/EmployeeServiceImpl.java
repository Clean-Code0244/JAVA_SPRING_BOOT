package com.omertursun.jwt.service.impl;

import com.omertursun.jwt.dto.DtoDepartment;
import com.omertursun.jwt.dto.DtoEmployee;
import com.omertursun.jwt.model.Department;
import com.omertursun.jwt.model.Employee;
import com.omertursun.jwt.repository.EmployeeRepository;
import com.omertursun.jwt.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DtoEmployee findEmployeeById(Long employeeId) {
        Optional<Employee> optional =  employeeRepository.findById(employeeId) ;
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        if(optional.isPresent()) {
            Employee employee = optional.get();
            Department department = employee.getDepartment();

            BeanUtils.copyProperties(employee, dtoEmployee);
            BeanUtils.copyProperties(department, dtoDepartment);
            dtoEmployee.setDtoDepartment(dtoDepartment);
        }
        return dtoEmployee;
    }
}
