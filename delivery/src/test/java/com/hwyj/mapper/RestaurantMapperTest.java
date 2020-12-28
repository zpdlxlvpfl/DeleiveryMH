package com.hwyj.mapper;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.ResMenuVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantMapperTest {
	
	@Autowired
	private RestaurantMapper mapper;
	
	@Test //메뉴보기 테스트
	public void testReadMenu() {
		List<ResMenuVO> menu= mapper.readMenu("restaurant89");
		for(ResMenuVO temp:menu) {
			log.info("메뉴보기: "+temp);
		}		
	}

	
}
