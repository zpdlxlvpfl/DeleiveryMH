package com.hwyj.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.hwyj.domain.CustomerVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private CustomerVO customerVO;
	
	public CustomUser(String id, String pw, Collection<? extends GrantedAuthority> authorities) {
		super(id, pw, authorities);
	}
	
	public CustomUser(CustomerVO customerVO) {
		super(customerVO.getId(), customerVO.getPw(),
				customerVO.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.customerVO= customerVO;
	}

}
