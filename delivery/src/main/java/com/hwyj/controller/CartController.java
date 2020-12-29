package com.hwyj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;
import com.hwyj.security.domain.CustomUser;
import com.hwyj.service.CartService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/cart/*")
@AllArgsConstructor
public class CartController {
	
	private CartService cartService;
	
	@GetMapping("myCart") //장바구니 페이지
	public void myCart() {
		
	}
	
//	@GetMapping("insert") //장바구니 담기 (주문하기 눌렀을 때)
//	public String insert(HttpSession session, CartVO cartVO) {
//		String id=(String)session.getAttribute("id");
//		if(id!=null) {
//			cartVO.setId(id);
//			cartService.ShoppingCart1(cartVO);
//			return "redirect:/cart/myCart";
//			
//		}else {
//			return "redirect:/login";
//		}	
//	}
	
	@GetMapping("cartTest") //장바구니 담기 테스트중
	public void cartTest() {
		
	}
	@GetMapping("insertTest")
	public void test(CartVOList cartVOList) {
		
	}
	
	HttpSession session;
	@GetMapping("insert") //장바구니 담기 (주문하기 눌렀을 때)
	public String insert(HttpSession session, CartVOList cartVOList) {
		
		String id=(String)session.getAttribute("id");
		log.info("아이디 왜 없어"+id);
		if(id!=null) {
			cartService.ShoppingCart(cartVOList);
			return "redirect:/cart/myCart";
			
		}else {
			return "redirect:/login";
		}	
	}

	
	
}