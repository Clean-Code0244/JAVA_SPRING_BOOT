package com.omertursun.jwt.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final UserDetailsService userDetailsService;
    private JwtService jwtService;
    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header;
        String token;
        String username;


        header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            //Controller katmanına geçemeden geri dönderdim. Login page olabilir burası.
            filterChain.doFilter(request, response);
            return;
        }
        token = header.substring(7);
        try{
            username= jwtService.getUsername(token);
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =  userDetailsService.loadUserByUsername(username);
                if(userDetails != null && jwtService.isTokenExpired(token)) {
                    // SecurityContext e konulabilir kişi. BU sayede controller a erişim sağlayabilir.
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                    authentication.setDetails(userDetails);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    //Burdan sonrasında Controller a erişim sağlanabilir.
                }
            }
        }
        catch (ExpiredJwtException e){
            System.out.println("JWT token expired" + e.getMessage());
        }
        catch (Exception e){
            System.out.println("General Exception" + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
