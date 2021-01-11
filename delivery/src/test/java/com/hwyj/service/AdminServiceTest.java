package com.hwyj.service;

import static org.junit.Assert.assertNotNull; 

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
public class AdminServiceTest {
	
	@Autowired
	private AdminService service;
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test //권한별 멤버 목록 보기 테스트 (+페이징 처리)
	public void testGetListP() {
		
		Criteria criteria = new Criteria(2, 10, "ROLE_MEMBER");

		List<CustomerVO> memberList=service.getMemberList(criteria);
		for(CustomerVO temp : memberList) {
			log.info(temp);
		}		
	}
	
//	@Test //권한별로 멤버 목록보기 테스트
//	public void getMemberList() {
//		List<CustomerVO> memberList=service.getMemberList("ROLE_ADMIN");
//		log.info("목록보기-----------------");
//		for(CustomerVO temp : memberList) {
//			log.info(temp);
//		}
//	}
	
	@Test //멤버정보 상세보기 테스트
	public void getMemberInfo() {
		CustomerVO customerVO = new CustomerVO();
		customerVO=service.getMemberInfo("user4");
		log.info("멤버정보: "+customerVO);
	}
	
	@Test //멤버삭제 테스트
	public void deleteMemberTest() {
		service.deleteMember("user59");
		log.info("멤버삭제 성공여부: "+service.deleteMember("user41")); //true or false
	}
	
	@Test //멤버 검색 테스트
	public void testSearch() {
		log.info("멤버: "+service.search("restaurant"));
	}

}
