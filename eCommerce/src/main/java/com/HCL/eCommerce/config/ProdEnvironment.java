package com.HCL.eCommerce.config;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.HCL.eCommerce.service.interfaces.AppEnvironment;

@Component
@Profile("prod")
//some code for changing properties related with the environment you are running
public class ProdEnvironment implements AppEnvironment {

	@Override
	public String name() {
		return "prod";
	}
}
