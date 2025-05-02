package com.omertursun.jwt.controller;

import com.omertursun.jwt.dto.DtoUser;
import com.omertursun.jwt.jwt.AuthRequest;
import com.omertursun.jwt.jwt.AuthResp;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);
    public AuthResp authenticate(AuthRequest request);

}
