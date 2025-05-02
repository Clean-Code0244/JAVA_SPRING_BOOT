package com.omertursun.jwt.service;

import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

    public AuthResp refreshToken(RefreshTokenRequest refreshToken);

}
