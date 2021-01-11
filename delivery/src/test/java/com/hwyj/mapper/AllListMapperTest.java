package com.hwyj.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.OrderVO;
import com.hwyj.service.AllListDaoImpl;
import com.hwyj.service.OrderService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AllListMapperTest {
	@Autowired
	private AllListDaoImpl dao;
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(dao);
		assertNotNull(dao);
	}
	

	@Test
	public void TestResInfo() {
		dao resInfo = new dao();
		HashMap<String, Object> ResInfoList = new HashMap<String, Object>();
		System.out.println("@@@@@@HASH@@@@@@@@@"+ResInfoList);
	}
		
	
	
	
	
	
	}


	

	

