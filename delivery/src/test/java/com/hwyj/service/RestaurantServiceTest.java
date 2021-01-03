package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public void testresList() {
		List<ResVO> resList=service.restList();
		for(ResVO temp : resList) {
			log.info("res: "+temp);
		}		
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
}
