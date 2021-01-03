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
	
	@Test //내정보보기
	public void testGetMyInfo() {
		log.info("내정보: "+mapper.read("user4"));
	}
	
	@Test //내정보 수정 테스트
	public void testUpdate() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user55");
		customerVO.setM_name("수정이름");
		log.info("내정보 수정 성공이면 1: "+mapper.update(customerVO));
	}
	
	@Test //아이디 찾기 테스트
	public void testFindId() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setEmail("abc1234@gamil.com");
		customerVO.setM_name("이름수정");
		customerVO=mapper.findId(customerVO);
		log.info("아이디찾기: "+customerVO);
	}
	
	@Test //비밀번호 찾기 테스트
	public void testFindPw() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("user3");
		customerVO.setEmail("test@gmail.com");
		customerVO.setM_name("일반사용자3");
		log.info("해당회원 있으면 1: "+mapper.findPw(customerVO));
	}
	
	@Test //비밀번호 변경 테스트
	public void testUpdatePw() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("13aa");
		customerVO.setPw("qlqjsqusrud");
		mapper.updatePw(customerVO);
	}
	
	@Test //회원가입-권한등록 테스트
	public void testInsertAuth() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("test3");
		customerVO.setAuth("ROLE_MEMBER");
		log.info("권한등록 : "+mapper.insertAuth(customerVO));
	}
	

}
