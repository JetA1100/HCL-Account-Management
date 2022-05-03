package com.HCL.eCommerce.entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
public class User implements UserDetails {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	private boolean active;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(role.getName())));
		return list;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return active;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return active;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}
	
	@Override
	public boolean isEnabled() {
		return active;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void setUsername(String string) {
		username = string;
		
	}

	public void setPassword(String encode) {
		password = encode;
	}

	public void setActive(boolean b) {
		active = b;
		
	}

	public void setRoles(List<Role> asList) {
		roles = asList;
		
	}
}
