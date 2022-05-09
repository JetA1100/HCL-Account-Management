package com.HCL.eCommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountManagementApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountManagementApplication.class);

	public static void main(String[] args) {
		logger.error("Error log from {} for logging level {}", AccountManagementApplication.class.getSimpleName(), "ERROR");
		SpringApplication.run(AccountManagementApplication.class, args);
	}

}
