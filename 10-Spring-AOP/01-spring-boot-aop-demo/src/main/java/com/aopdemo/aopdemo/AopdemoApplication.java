package com.aopdemo.aopdemo;

import com.aopdemo.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return args -> {
			demoBeforeAdvice(theAccountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO) {

		theAccountDAO.addAccount();
	}

}
