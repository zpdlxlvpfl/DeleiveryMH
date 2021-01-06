package com.hwyj.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.OrderVO;
import com.hwyj.service.OrderService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMapperTest {
	@Autowired
	private OrderMapper orderMapper;
	
	@Test 
	public void OrderList() {
		OrderVO orderVO = new OrderVO();
		log.info("START"+ orderMapper.OrderList(orderVO));
		}
	
	
	
	@Test 
	public void insertOrder() {
		OrderVO orderVO = new OrderVO();
		orderMapper.insertOrder(orderVO);
		
		orderVO.setOrder_no("2");
		orderVO.setRes_code("test");
		orderVO.setRes_menu_code("test");
		orderVO.setRes_menu_acount("test");
		orderVO.setDel_id("test");
		orderVO.setId("test");
		orderVO.setOrder_count(1);
		System.out.println(orderVO);
		}
	
	
	
	
	
	}


	

	

