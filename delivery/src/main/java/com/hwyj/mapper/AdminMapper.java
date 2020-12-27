package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.CustomerVO;

public interface AdminMapper {
	
	
	//권한별로 멤버 목록 보기 (관리자 페이지에서)
	public List<CustomerVO> getMemberList(String auth);
	
	//멤버정보 상세보기
	public CustomerVO read(String id);
		
	//멤버 삭제 (member 테이블, auth 테이블 둘 다 삭제됨)
	public int deleteMember(String id);
	
	

}
