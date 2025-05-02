package com.omertursun.jwt.service;

import com.omertursun.jwt.dto.DtoUser;
import com.omertursun.jwt.jwt.AuthRequest;
import com.omertursun.jwt.jwt.AuthResp;

public interface IAuthService {

    public DtoUser register(AuthRequest request);
    public AuthResp authenticate(AuthRequest request);
}
