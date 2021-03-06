package com.hwyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hwyj.domain.Criteria;
import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.AdminMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	private AdminMapper adminMapper;
	
	
	//전체회원수 구하기
	@Override
	public int getTotal(Criteria criteria) {
		
		return adminMapper.getTotalCount(criteria);
	}
	
	//권한별로 멤버 목록 보기 (관리자 페이지에서) + 페이징처리
	@Override
	public List<CustomerVO> getMemberList(Criteria criteria) {
		
		return adminMapper.getMemberList(criteria);
	}

//	//멤버 목록 보기 서비스
//	@Override
//	public List<CustomerVO> getMemberList(String auth) {
//		log.info("멤버 목록 보기: "+adminMapper.getMemberList(auth));
//		return adminMapper.getMemberList(auth);
//	}
		
	//멤버정보 상세보기 서비스
	@Override
	public CustomerVO getMemberInfo(String id) {
		log.info("멤버정보 상세보기: "+adminMapper.read(id));	
		return adminMapper.read(id);
	}
	
	//멤버 삭제하기 서비스
	@Override
	public boolean deleteMember(String id) {
		log.info("삭제----------");
		return adminMapper.deleteMember(id)==1; //삭제처리가 정상적으로 되면 1리턴 -> 1==1이면 true
	}

	//멤버 아이디 검색
	@Override
	public List<CustomerVO> search(String keyword) {
		
		return adminMapper.search(keyword);
	}


}
