package com.hwyj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwyj.domain.CartVO;
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
	
	@GetMapping("insert") //장바구니 담기 (주문하기 눌렀을 때)
	public String insert(HttpSession session, CartVO cartVO) {
		String id=(String)session.getAttribute("id");
		if(id!=null) {
			cartVO.setId(id);
			cartService.ShoppingCart(cartVO);
			return "redirect:/cart/myCart";
			
		}else {
			return "redirect:/login";
		}
		
		
		
	}

}
