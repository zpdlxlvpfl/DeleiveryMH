package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
	   	String str = orderVO.getOrder_no();
	     Calendar cal = Calendar.getInstance();
	     int year = cal.get(Calendar.YEAR);
	     String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	     String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
	     String subNum = "";
	     
	     
	     for(int i = 1; i <= 6; i ++) {
	      subNum += (int)(Math.random() * 10);
	     }
	     //order_no,res_code,res_menu_code,res_menu_price,res_menu_acount,del_id,id,order_date,order_count
	    str = ymd + "_" + subNum;
		
		orderVO.setOrder_no(str);
		orderVO.setRes_code(str);
		orderVO.setRes_menu_code("9");
		orderVO.setId("user");
		service.insertOrder(orderVO);
		orderVO.setDel_id("9");
	
		orderVO.setRes_menu_price("9");
		log.info(orderVO);
		
		}
	

	@Test 
	public void OrderList() {
		OrderVO vo = new OrderVO ( );
		vo.setId("user4");
		HashMap<String, Object> hashMapList = new HashMap<String, Object>();
		System.out.printf("====hash=====",hashMapList);
	
	}
	
	
	
	
	
	}


	

	

