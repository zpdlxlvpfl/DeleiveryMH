package com.hwyj.mapper;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.MemberVO;

public interface MemberMapper {
	
		//로그인
		public MemberVO login(String id);
		
		//내정보 수정
		public int update(MemberVO memberVO);
			
					
		
	
		//회원가입
		public int insertCustomer(CustomerVO csVO);
			
		

		//아이디 중복체크
		public String selectCustomer(CustomerVO csVO);




}
