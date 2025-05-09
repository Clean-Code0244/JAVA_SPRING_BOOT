package com.omertursun.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
                .username("John")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE,MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE,MANAGER,ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")

                                .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )

                .logout(logout ->logout.permitAll())
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/showMyAccessDeniedPage"));




        return http.build();
    }
//    @Bean
//    @Order(1)
//    public SecurityFilterChain securedFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/secured/**")
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/secured/login")
//                        .loginProcessingUrl("/secured/login")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/secured/logout")
//                        .logoutSuccessUrl("/secured/login?logout")
//                        .permitAll()
//                )
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
}
