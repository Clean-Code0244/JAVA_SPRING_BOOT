package com.omertursun.jwt.controller.impl;

import com.omertursun.jwt.controller.IRestAuthController;
import com.omertursun.jwt.dto.DtoUser;
import com.omertursun.jwt.jwt.AuthRequest;
import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {
    private IAuthService authService;

    @Autowired
    public RestAuthControllerImpl(IAuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return authService.register(request);
    }
    @PostMapping("/authenticate")
    @Override
    public AuthResp authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }

}
