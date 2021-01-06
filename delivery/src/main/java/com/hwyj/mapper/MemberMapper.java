package com.hwyj.mapper;

import com.hwyj.domain.CustomerVO; 

public interface MemberMapper {
	
		//로그인
		public CustomerVO login(String id);
		
		//내정보 보기
		public CustomerVO read(String id);
		
		//내정보 수정
		public int update(CustomerVO customerVO);
		
		//아이디 찾기 (이메일과 이름으로)
		public CustomerVO findId(CustomerVO customerVO);
		
		//비밀번호 찾기(이메일,이름,아이디로 해당회원 있는지 찾고 / 임시비밀번호 발급)
		public int findPw(CustomerVO customerVO);
			
		//비밀번호 변경
		public int updatePw(CustomerVO customerVO);
	
		//회원가입
		public int insertCustomer(CustomerVO csVO);
		
		//회원가입-권한 등록
		public int insertAuth(CustomerVO customerVO);
			
		public String enabled(CustomerVO csVO);
		
		//아이디 중복체크
		public String selectCustomer(CustomerVO csVO);




}
