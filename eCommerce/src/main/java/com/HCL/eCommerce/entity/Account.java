package com.HCL.eCommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account", uniqueConstraints = {
		@UniqueConstraint(name = "UniqueName", columnNames = {"name"}),
		@UniqueConstraint(name = "UniqueURL", columnNames = {"url"})
})
@Getter
@Setter
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String url;
	private String name;
	private String bio;
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
}
