package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.Criteria;
import com.hwyj.domain.CustomerVO;

public interface AdminService {
	
	//전체회원수 구하기
	public int getTotal(Criteria criteria);
	
	//권한별로 멤버 목록 보기 (관리자 페이지에서) + 페이징처리
	public List<CustomerVO> getMemberList(Criteria criteria);
	
//	//권한별 멤버 목록 보기
//	public List<CustomerVO> getMemberList(String auth);
	
	//멤버 정보 상세보기 (id를 통해서)
	public CustomerVO getMemberInfo(String id);
	
	//멤버 삭제하기
	public boolean deleteMember(String id);
	
	//멤버 아이디 검색
	public List<CustomerVO> search(String keyword);

}
