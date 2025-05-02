package com.omertursun.jwt.controller;

import com.omertursun.jwt.dto.DtoEmployee;

public interface IRestEmployeeController {

    public DtoEmployee findEmployeeById(Long employeeId);
}
