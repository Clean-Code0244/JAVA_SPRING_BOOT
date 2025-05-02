package com.omertursun.jwt.service.impl;

import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.jwt.JwtService;
import com.omertursun.jwt.jwt.RefreshTokenRequest;
import com.omertursun.jwt.model.RefreshToken;
import com.omertursun.jwt.model.User;
import com.omertursun.jwt.repository.RefreshTokenRepository;
import com.omertursun.jwt.service.IRefreshTokenService;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    private RefreshTokenRepository refreshTokenRepository;
    private JwtService jwtService;
    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, JwtService jwtService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtService = jwtService;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setRefreshToken(UUID.randomUUID().toString());
        refreshTokenEntity.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshTokenEntity.setUser(user);

        return refreshTokenEntity;

    }

    public boolean isRefreshTokenExpired(Date expiryDate) {
        return new Date().before(expiryDate);
    }
    @Override
    public AuthResp refreshToken(RefreshTokenRequest request) {
        RefreshToken saved = null;
        String accessToken= "";
        RefreshToken new_refresh_token = null;
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
        if(refreshToken.isPresent()) {
            RefreshToken refreshTokenEntity = refreshToken.get();
            if(!isRefreshTokenExpired(refreshTokenEntity.getExpiryDate())) {
                System.out.println("Refresh token expired");
            }
            accessToken = jwtService.generateToken(refreshToken.get().getUser());
            new_refresh_token = createRefreshToken(refreshToken.get().getUser());
            saved = refreshTokenRepository.save(new_refresh_token);

        }
        return new AuthResp(accessToken, new_refresh_token.getRefreshToken());
    }
}
