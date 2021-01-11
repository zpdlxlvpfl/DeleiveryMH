package com.hwyj.mapper;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.Criteria;
import com.hwyj.domain.CustomerVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTest {
	
	@Autowired
	private AdminMapper mapper;
	
	
	@Test //권한별 멤버 목록 보기 테스트 (+페이징 처리)
	public void testGetListP() {
		
		Criteria criteria = new Criteria(1, 10, "ROLE_MEMBER");

		List<CustomerVO> memberList=mapper.getMemberList(criteria);
		for(CustomerVO temp : memberList) {
			log.info(temp);
		}		
	}
	
//	@Test //권한별 멤버 목록 보기 테스트
//	public void testGetList() {
//		List<CustomerVO> memberList=mapper.getMemberList("ROLE_MEMBER");
//		for(CustomerVO temp : memberList) {
//			log.info(temp);
//		}		
//	}
	
	@Test //멤버정보 상세보기 테스트
	public void testRead() { 	
		CustomerVO customerVO=mapper.read("user3");
		log.info("read------------- "+customerVO);
	}
	
	@Test //멤버 삭제 테스트
	public void testDeleteMember() {
		log.info("멤버 삭제 확인: "+mapper.deleteMember("user95"));
	}
	
	@Test //멤버 검색 테스트
	public void testSearch() {
		log.info("멤버: "+mapper.search("restaurant"));
	}


}
