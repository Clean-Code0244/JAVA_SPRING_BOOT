package com.omertursun.jwt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    private UserDetailsService userDetailsService;

    private static final String SECRET_KEY = "PROtan0tLBdxKLMvo3wX8UkDtjkaldSjmnPxOMtxngA=";

    @Autowired
    public JwtService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        //loadUserByUserName metodu veri tabanı bağlanıtısını kullanarak veri tabanındaki isimle aynı mı diye kontrol etmek için kullanılan ek bir güvenlik katmanı olarak düşünülebilir.
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put( "role","ROLE_ADMIN");
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 2))
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();

    }

    public  Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }



    public  Object getRoleByClaims(String  token, String key) {
        Claims claims = getClaims(token);
        return claims.get(key);

    }

    public  Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    public <T> T exportToken(String token, Function<Claims,T> function) {

        Claims claims = getClaims(token);

        return function.apply(claims);
    }

    public String getUsername(String token) {
        return exportToken(token, Claims::getSubject);
    }
    public boolean isTokenExpired(String token) {
        Date expiredDate = exportToken(token,Claims::getExpiration);
        return new Date().before(expiredDate);
    }


}
