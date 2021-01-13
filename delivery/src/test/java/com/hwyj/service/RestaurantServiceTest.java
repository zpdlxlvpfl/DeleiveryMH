package com.hwyj.service;


import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.controller.UtilController;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantServiceTest {
	
	@Autowired
	private RestaurantService service;
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void read () {
		String RES_CODE = "";
		service.read(RES_CODE);
		log.info(RES_CODE);
		System.out.println(RES_CODE);
	}
		
	
	@Test
	public void menuread () {
		ResMenuVO vo = new ResMenuVO();
		
		String RES_CODE = "";
		vo.setRES_CODE("res_01");
		service.menuread(RES_CODE);
		log.info(RES_CODE);
		System.out.println(RES_CODE);
	}
		
	@Test
	public void menuList() throws Exception {
		ResMenuVO vo = new ResMenuVO();
		String RES_CODE = "res_01";
		List<ResMenuVO> menuList = new ArrayList<>();
		service.menuread(RES_CODE);
		service.menuList();
		
		System.out.println(service.menuList() + "LIST@@@@@@@@@@@@@@@@@@@");
	}
	
	@Test
	public void restList() throws Exception {
		String RES_CODE = "";
		List<ResVO> restList = new ArrayList<>();
		restList = service.restList();
		System.out.println(restList + "RestList@@@@@@@@@@@@@");
		service.read(RES_CODE);
		System.out.println("=======list====" + restList);
		
		log.info(restList);
		log.info(RES_CODE);
	}
		

	
	
}
