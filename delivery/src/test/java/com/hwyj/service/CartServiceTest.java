package com.hwyj.service;

import static org.junit.Assert.assertNotNull ;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

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
		cartVO.setId("user31");
		cartVO.setRes_menu_code("res_02B02");
		cartVO.setAmount(2);
		log.info("장바구니 담기 성공? "+service.ShoppingCart(cartVO));
	}
	
	@Test //장바구니 보기 서비스 테스트
	public void testCartList() {
		List<CartVO> cartList=service.cartList("user4");
		for(CartVO temp : cartList) {
			log.info("장바구니 목록: "+temp);
		}
	}
	
	@Test //장바구니 수량 수정 서비스 테스트
	public void testModifyAmount() {
		CartVO cartVO = new CartVO();
		cartVO.setAmount(4);
		cartVO.setCart_no(121);
		log.info("수량 수정 성공? "+service.modifyAmount(cartVO));
	}
	
	@Test //장바구니 메뉴 삭제 서비스 테스트
	public void testRemoveMenu() {
	
		log.info("장바구니 메뉴 성공? "+service.removeMenu(3));
	}
	
	@Test //장바구니 전체삭제 서비스 테스트
	public void testRemoveAll() {
		log.info("장바구니 전체 삭제 성공? "+service.removeAll("user9"));
	}
	
//	@Test //장바구니-메뉴 여러개 한번에 담는 서비스 테스트
//	public void testShoppingCart() {
////		List<CartVO> cartList = new ArrayList<CartVO>();
////		CartVO cartVO1=new CartVO();
////		CartVO cartVO2=new CartVO();
////		
////		cartVO1.setId("user10"); //아이디
////		cartVO1.setRes_menu_code("res_02A01"); //1만2천원 파스타 10개
////		cartVO1.setAmount(10);
////		cartList.add(cartVO1);
////		
////		cartVO2.setId("user10"); //아이디
////		cartVO2.setRes_menu_code("res_02B01"); //1만5천원 리조또 3개
////		cartVO2.setAmount(3);
////		cartList.add(cartVO2);
//		CartVOList cartVOList = new CartVOList();
//		List<CartVO> cartList = new ArrayList<CartVO>();
//		CartVO cartVO1 = new CartVO();
//		CartVO cartVO2 = new CartVO();
//		
//		cartVO1.setId("user12");
//		cartVO1.setRes_menu_code("res_02A01"); //1만2천원 기본파스타 3개
//		cartVO1.setAmount(3);
//		cartList.add(cartVO1);
//		
//		cartVO2.setId("user12");
//		cartVO2.setRes_menu_code("res_02B01"); //1만5천원 리조또 1개
//		cartVO2.setAmount(1);
//		cartList.add(cartVO2);
//		
//		cartVOList.setList(cartList);
//		
//		log.info("메뉴 몇개 담았지?: "+service.ShoppingCart(cartVOList));
//		
//	}

}
