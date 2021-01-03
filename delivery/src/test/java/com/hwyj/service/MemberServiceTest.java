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
	
	@Test //내정보 보기 서비스 테스트
	public void testGetMyInfo() {
		log.info("내정보: "+service.getMyInfo("user4"));
	}
	
	@Test //내정보 수정하기 서비스 테스트
	public void testModifyMyInfo() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user55");
		customerVO.setM_name("또수정");
		log.info("내정보 수정 성공여부: "+service.modifyMyInfo(customerVO));
	}
	
	@Test //아이디 찾기 서비스 테스트
	public void testFindId() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setEmail("abc1234@gamil.com");
		customerVO.setM_name("이름수정");
		customerVO=service.findId(customerVO);
		log.info("아이디 찾기: "+customerVO);
	}
	
	@Test //비밀번호 찾기 서비스 테스트(해당회원 있는지 확인)
	public void testFindPw() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user3");
		customerVO.setEmail("test@gmail.com");
		customerVO.setM_name("일반사용자3");
		log.info("회원있으면 true: "+service.findPw(customerVO));
	}
	
	@Test //비밀번호 변경 서비스 테스트
	public void testUpdatePw() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("13aa");
		customerVO.setPw("tjdrhd");
		log.info("비번변경 성공? "+service.updatePw(customerVO));
	}
	
	 @Test //회원가입 +권한등록 서비스 테스트
	 public void testInsertCustomer() {
		 CustomerVO customerVO = new CustomerVO();
		 customerVO.setId("test4");
		 customerVO.setPw("555");
		 customerVO.setM_name("테스트4이름");
		 customerVO.setAuth("ROLE_RES");
		 service.insertCustomer(customerVO);
	 }
	
}
