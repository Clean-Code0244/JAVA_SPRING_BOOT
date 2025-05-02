package com.omertursun.jwt.controller.impl;

import com.omertursun.jwt.controller.IRestRefreshTokenController;
import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.jwt.RefreshTokenRequest;
import com.omertursun.jwt.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshTokenControllerImpl implements IRestRefreshTokenController {

    private IRefreshTokenService refreshTokenService;
    @Autowired
    public RefreshTokenControllerImpl(IRefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public AuthResp refreshToken(@RequestBody  RefreshTokenRequest refreshToken) {
        return null;
    }
}
