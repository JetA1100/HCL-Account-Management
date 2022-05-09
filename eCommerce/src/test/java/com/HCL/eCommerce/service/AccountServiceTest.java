package com.HCL.eCommerce.service;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {

	AccountService accountService;
	@BeforeEach
	void setUp() throws Exception {
		accountService = new AccountService();
	}
	
	@Test
	void findByIdTest() {
	    Assertions.assertEquals(3, accountService.findById(1));
	}
}
