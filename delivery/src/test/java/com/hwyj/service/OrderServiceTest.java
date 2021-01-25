package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.controller.UtilController;
import com.hwyj.domain.CartVO;
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
	public void getOrderList() throws Exception {
			CartVO vo = new CartVO();	
			String id = "user15";
			vo.setId("user15");
			vo.setPayment("Y");
			HashMap<String, Object> HashMapList = new HashMap<String, Object>();
			List<String> getOrderList = service.orderList(id);
			UtilController util = new UtilController();
			vo.setPayment("Y");
			for(int i = 0; i < getOrderList.size(); i++){
	            // ArrayList 사이즈 만큼 for문을 실행한다.
	            log.info("===========list 순서============ " + i + "번쨰");
	            for( Entry<String, Object> eleEntry : HashMapList.entrySet() ){
	                // list 각각 HashMap받아서 출력한다.
	                log.info(String.format("키 : %s, 값 : %s", eleEntry.getKey(), eleEntry.getValue()) );
	            }
	        }
			System.out.println("=====OrderList=====" + getOrderList);
			System.out.println("=====HashMapList=====" + HashMapList);
			
	}
	
	
	
	
	
	}


	

	

