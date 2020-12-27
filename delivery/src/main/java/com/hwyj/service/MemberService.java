package com.hwyj.service;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.MemberVO;

public interface MemberService {
	
	//내정보 수정
	public boolean modifyMyInfo(MemberVO memberVO);
	
	// 중복검사 ,회원가입
	public int insertCustomer(CustomerVO csVO);
	
	public String enabled(CustomerVO csVO);
	
}
