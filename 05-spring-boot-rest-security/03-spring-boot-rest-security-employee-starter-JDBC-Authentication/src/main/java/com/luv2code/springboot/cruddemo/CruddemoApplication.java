package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CruddemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CruddemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
}
