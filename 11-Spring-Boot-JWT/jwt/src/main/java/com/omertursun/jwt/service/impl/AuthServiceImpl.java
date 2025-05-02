package com.omertursun.jwt.service.impl;

import com.omertursun.jwt.dto.DtoUser;
import com.omertursun.jwt.jwt.AuthRequest;
import com.omertursun.jwt.jwt.AuthResp;
import com.omertursun.jwt.jwt.JwtService;
import com.omertursun.jwt.model.RefreshToken;
import com.omertursun.jwt.model.User;
import com.omertursun.jwt.repository.RefreshTokenRepository;
import com.omertursun.jwt.repository.UserRepository;
import com.omertursun.jwt.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthenticationProvider authenticationProvider;
    private JwtService jwtService;
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider, JwtService jwtService, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.jwtService = jwtService;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setRefreshToken(UUID.randomUUID().toString());
        refreshTokenEntity.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshTokenEntity.setUser(user);

        return refreshTokenEntity;

    }


    @Override
    public DtoUser register(AuthRequest request) {
        User user = new User();
        user.setUserName(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResp authenticate(AuthRequest request) {

        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
            Optional<User> optional =  userRepository.findByUserName(request.getUsername());
            UserDetails user = optional.orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı"));
            String accessToken = jwtService.generateToken(user);
            RefreshToken refreshToken = createRefreshToken(optional.get());
            return new AuthResp(accessToken,refreshToken.getRefreshToken());
        }
        catch (Exception e) {
            System.out.println("Authentication failed: Kullanıcı adı ya da şifre hatalı" + e.getMessage());
        }
         return null;
    }
}
