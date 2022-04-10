package com.HCL.eCommerce.vo;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountVO {
	private int id;
	@NotEmpty
	private String url;
	@NotEmpty
	private String name;
	@NotEmpty
	private String bio;
	
	public int getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBio() {
		return bio;
	}
}
