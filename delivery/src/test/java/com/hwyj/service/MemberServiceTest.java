package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CustomerVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService service;
	
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test //내정보 수정하기 서비스 테스트
	public void testModifyMyInfo() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user55");
		customerVO.setM_name("또수정");
		log.info("내정보 수정 성공여부: "+service.modifyMyInfo(customerVO));
	}
	

}
