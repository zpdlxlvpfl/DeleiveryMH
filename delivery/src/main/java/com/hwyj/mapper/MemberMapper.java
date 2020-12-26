package com.hwyj.mapper;

import com.hwyj.domain.CustomerVO;

public interface MemberMapper {
	
		//로그인
		public CustomerVO login(String id);
		
		//내정보 수정
		public int update(CustomerVO customerVO);
			
					
		
	
		//회원가입
		public int insertCustomer(CustomerVO csVO);
			
		

		//아이디 중복체크
		public String selectCustomer(CustomerVO csVO);




}
