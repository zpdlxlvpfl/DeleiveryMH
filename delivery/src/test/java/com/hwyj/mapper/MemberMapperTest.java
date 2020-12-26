package com.hwyj.mapper;

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
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test //로그인 멤버정보 읽기 테스트
	public void testLogin() {
		CustomerVO customerVO=mapper.login("admin90");
		log.info("login----------- ");
		customerVO.getAuthList().forEach(authVO -> log.info(authVO));
		
	}
	
	@Test //내정보 수정 테스트
	public void testUpdate() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user55");
		customerVO.setM_name("수정이름");
		log.info("내정보 수정 성공이면 1: "+mapper.update(customerVO));
	}
	
	

}
