package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.OrderVO;
import com.hwyj.service.OrderService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderServiceTest {
	@Autowired
	private OrderService service;
	
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	
	
	@Test 
	public void insertOrder() {
		OrderVO orderVO = new OrderVO();
		service.insertOrder(orderVO);
		orderVO.setOrder_no("9");
		orderVO.setDel_id("9");
		orderVO.setId("9");
		orderVO.setRes_code("9");
		orderVO.setRes_menu_code("9");
		orderVO.setRes_menu_acount("9");
		orderVO.setRes_menu_price("9");
		orderVO.setOrder_count(0);
		log.info("@@@@@@@@@@@" + service.insertOrder(orderVO));
		
		}
	
	
	
	
	
	}


	

	

