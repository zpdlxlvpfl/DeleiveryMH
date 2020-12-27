package com.hwyj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Setter(onMethod_= { @Autowired })
	private MemberMapper memberMapper;

	@Override //UserDetails -> 사용자의 정보와 권한정보 등을 담음
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		log.warn("아이디: "+id);
		
		CustomerVO customerVO=memberMapper.login(id);
		
		log.warn("멤버정보: "+customerVO);
		
		return customerVO == null ? null:new CustomUser(customerVO); //customerVO가 있으면 CustomUser 객체 생성
	}
	

}
