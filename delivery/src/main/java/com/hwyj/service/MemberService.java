package com.hwyj.service;

import com.hwyj.domain.CustomerVO;

public interface MemberService {
	
	//내정보 수정
	public boolean modifyMyInfo(CustomerVO customerVO);
	
	// 중복검사 ,회원가입
	public int insertCustomer(CustomerVO csVO);
	
<<<<<<< HEAD
	public String enabled(CustomerVO csVO);
=======
	//아이디 찾기
	public CustomerVO findId(CustomerVO customerVO);
>>>>>>> 5423cbcc703407b9753d4f6a1966559ef9e78101
	
}
