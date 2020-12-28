package com.hwyj.service;

import com.hwyj.domain.CustomerVO;

public interface MemberService {
	
	//내정보 수정
	public boolean modifyMyInfo(CustomerVO customerVO);
	
	// 중복검사 ,회원가입 (+권한등록)
	public int insertCustomer(CustomerVO csVO);
	
	public String enabled(CustomerVO csVO);
	
<<<<<<< HEAD
	public String selectCustomer(CustomerVO csVO);
	
	
=======
>>>>>>> branch 'master' of https://github.com/zpdlxlvpfl/DeleiveryMH
	public CustomerVO findId(CustomerVO customerVO);
	
}
