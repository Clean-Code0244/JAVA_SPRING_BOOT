package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_name from employee where id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select role from employee_roles where employee_id=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/{employeeId}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/{employeeId}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/api/employees/**").hasRole("MANAGER")
        );
        //Http Basic Authenticaiton
        http.httpBasic(Customizer.withDefaults());

        // Disable csrf
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


//    @Bean
//   public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//       UserDetails john = User.builder()
//               .username("john")
//               .password("{noop}123test")
//               .roles("EMPLOYEE")
//               .build();
//
//       UserDetails mary = User.builder()
//               .username("mary")
//               .password("{noop}123test")
//               .roles("EMPLOYEE","MANAGER")
//               .build();
//
//       UserDetails susan = User.builder()
//               .username("susan")
//               .password("{noop}123test")
//               .roles("EMPLOYEE","MANAGER","ADMIN")
//               .build();
//
//       return new InMemoryUserDetailsManager(john, mary, susan);
//   }


}
