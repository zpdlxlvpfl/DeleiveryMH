package com.hwyj.mapper;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test //장바구니 목록보기 테스트
	public void testCartList() {
		List<CartVO> cartList=mapper.cartList("user4");
		for(CartVO temp : cartList) {
			log.info("장바구니 목록: "+temp);
		}
	}
	
	@Test //장바구니 메뉴 삭제 테스트
	public void testDeleteMenu() {
		log.info("메뉴삭제 성공이면 1: "+mapper.deleteMenu(3));
	}
	
//	@Test //장바구니 한번에 여러개 넣기 테스트
//	public void test() {
//		List<CartVO> list = new ArrayList<CartVO>();		
//		CartVO cartVO1 = new CartVO();
//		CartVO cartVO2 = new CartVO();
//		
//		cartVO1.setId("user11");
//		cartVO1.setRes_menu_code("res_01A01"); //짜장면 7천원짜리 2개
//		cartVO1.setAmount(2);
//		list.add(cartVO1);
//		
//		cartVO2.setId("user11");
//		cartVO2.setRes_menu_code("res_01A02"); //짬뽕 8천원짜리 1개
//		cartVO2.setAmount(1);
//		list.add(cartVO2);		
//		
//		log.info("장바구니 한번에 몇개 넣었을까 : "+mapper.insertCart(list));
//	}

}
