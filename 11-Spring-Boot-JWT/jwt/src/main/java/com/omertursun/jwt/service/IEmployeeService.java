package com.omertursun.jwt.service;

import com.omertursun.jwt.dto.DtoEmployee;

public interface IEmployeeService {

    DtoEmployee findEmployeeById(Long employeeId);
}
