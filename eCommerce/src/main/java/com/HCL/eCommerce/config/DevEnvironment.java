package com.HCL.eCommerce.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.HCL.eCommerce.service.CustomUserDetailsService;
import com.HCL.eCommerce.service.interfaces.AppEnvironment;

@Component
@Profile("dev")
public class DevEnvironment implements AppEnvironment {
	
	@Override
	public String name() {
		return "dev";
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, CustomUserDetailsService service) throws Exception {
	  builder.userDetailsService(service);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
	  return new BCryptPasswordEncoder();
	}
}
