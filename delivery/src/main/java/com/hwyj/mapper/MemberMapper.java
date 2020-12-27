package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.MemberVO;

public interface MemberMapper {
	
		//로그인
		public MemberVO login(String id);
		
		//내정보 수정
				public int update(MemberVO memberVO);
			
		
		//권한별로 멤버 목록 보기 (관리자 페이지에서)
		public List<MemberVO> getMemberList(String auth);
		
		//멤버정보 상세보기
		public MemberVO read(String id);
			
		//멤버 삭제 (member 테이블, auth 테이블 둘 다 삭제됨)
		public int deleteMember(String id);
		
		
		
	
		//회원가입
		public int insertCustomer(CustomerVO csVO);
			
		public String enabled(CustomerVO csVO);
		
		//아이디 중복체크
		public String selectCustomer(CustomerVO csVO);




}
