package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
   public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
       UserDetails john = User.builder()
               .username("john")
               .password("{noop}123test")
               .roles("EMPLOYEE")
               .build();

       UserDetails mary = User.builder()
               .username("mary")
               .password("{noop}123test")
               .roles("EMPLOYEE","MANAGER")
               .build();

       UserDetails susan = User.builder()
               .username("susan")
               .password("{noop}123test")
               .roles("EMPLOYEE","MANAGER","ADMIN")
               .build();

       return new InMemoryUserDetailsManager(john, mary, susan);
   }



}
