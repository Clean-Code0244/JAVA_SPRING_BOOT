package com.omertursun.jwt.controller;

import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.jwt.RefreshTokenRequest;

public interface IRestRefreshTokenController {

    public AuthResp refreshToken(RefreshTokenRequest refreshToken);

}
