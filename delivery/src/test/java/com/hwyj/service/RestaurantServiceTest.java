package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.awt.MenuComponent;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public void insertres()  throws Exception{
	     HttpSession session = null;
	     ResVO resvo = new ResVO();
	     ResMenuVO menuvo = new ResMenuVO();
		
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		String res_code = ymd + "_" + subNum;
		resvo.setRES_CODE(res_code);
		resvo.setRES_NAME("TESTTESTTEST");
		resvo.setRES_INFO("testinfo");
		resvo.setDEL_PRICE("5000");
		log.info(res_code);
		System.out.println(resvo);
		System.out.println(menuvo);
		
	}
	
	@Test
	public void insertmenutest( )  throws Exception{
	     ResMenuVO menuvo = new ResMenuVO();
	 	 ResVO resvo = new ResVO();
		 HttpSession session = null;
		
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		
		 
		String res_menu_code = ymd + "_Menu" + subNum;
		String res_code = resvo.getRES_CODE();
		menuvo.setRES_CODE(res_code);
		menuvo.setRes_menu_code(res_menu_code);
		menuvo.setRes_menu_explan("info");
		menuvo.setRes_menu_name("name");
		menuvo.setRes_menu_price("123123");
		service.insertmenu(menuvo);
		System.out.println(menuvo);
	}
	
	
	
	@Test
	public void menuList () { //code test
		Map<String, Object> map = new HashMap<String , Object>();
		ResMenuVO resmenu = new ResMenuVO();
	try {	
		map.put("menucode", resmenu.getRes_menu_code());
		
		for(String i : map.keySet()){ 
			System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
		} 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	
	@Test
	public void read (String RES_CODE) {
		service.read(RES_CODE);
		log.info(RES_CODE);
		System.out.println(RES_CODE);
	}
		
	@Test
	public void ResInfo () {
		ResVO resvo = new ResVO();
		service.ResInfo(resvo);
		log.info("@@@@@@@@@@@@ " + resvo);
		System.out.println(resvo);
	}
		
	
	
}
