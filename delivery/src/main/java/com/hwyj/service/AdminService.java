package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.CustomerVO;

public interface AdminService {
	
	//권한별 멤버 목록 보기
	public List<CustomerVO> getMemberList(String auth);
	
	//멤버 정보 상세보기 (id를 통해서)
	public CustomerVO getMemberInfo(String id);
	
	//멤버 삭제하기
	public boolean deleteMember(String id);

}
