package com.hwyj.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.hwyj.domain.CustomerVO;

public interface MemberService {
	
	//내정보 수정
	public boolean modifyMyInfo(CustomerVO customerVO);
	
	//내정보 보기
	public CustomerVO getMyInfo(String id);
	
	
	// 중복검사 ,회원가입 (+권한등록)
	public int insertCustomer(CustomerVO csVO);
	
	public String enabled(CustomerVO csVO);
	
	public String selectCustomer(CustomerVO csVO);
	
	
	//아이디 찾기
	public CustomerVO findId(CustomerVO customerVO);
	
	//비밀번호 찾기(이메일,이름,아이디로 해당회원 있는지 확인)
	public boolean findPw(CustomerVO customerVO);
	
	//비밀번호 변경
	public boolean updatePw(CustomerVO customerVO);
	
}
