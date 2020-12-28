package com.hwyj.service;

import static org.junit.Assert.assertNotNull ;

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
public class CartServiceTest {
	
	@Autowired
	private CartService service;
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test //장바구니 담기 서비스 테스트
	public void testShoppingCart() {
		CartVO cartVO=new CartVO();
		cartVO.setId("user30");
		cartVO.setRes_menu_code("res_02B02");
		cartVO.setAmount(2);
		log.info("장바구니 담기 성공? "+service.ShoppingCart(cartVO));
	}

}
