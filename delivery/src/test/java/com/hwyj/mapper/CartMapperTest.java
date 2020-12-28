package com.hwyj.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CartVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTest {
	
	@Autowired
	private CartMapper mapper;
	
	@Test //장바구니 넣기 테스트
	public void testInsertCart() {
		CartVO cartVO = new CartVO();
		cartVO.setId("user20");
		cartVO.setRes_menu_code("res_02B01");
		cartVO.setAmount(5);
		log.info("장바구니 성공이면 1: "+mapper.insertCart(cartVO));
	}

}
