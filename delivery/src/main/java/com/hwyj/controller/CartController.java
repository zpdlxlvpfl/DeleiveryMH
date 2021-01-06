package com.hwyj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@PreAuthorize("hasAnyRole('ROLE_MEMBER')") //일반사용자 전용 페이지
public class CartController {
	
	private CartService cartService;

	
	@GetMapping("myCart") //장바구니 페이지
	public void myCart(Authentication authentication, Model model) {
		
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); //현재 로그인한 유저 정보	
//		List<CartVO> cartList = cartService.cartList(userDetails.getUsername()); //장바구니 목록
//		
//		int sumTotal=0;
//		for(CartVO temp : cartList) {	
//			sumTotal+=temp.getSum(); //메뉴당 금액 다 더해서 주문 총금액
//		}
//		model.addAttribute("sumTotal", sumTotal);
//		model.addAttribute("cartList", cartList);			
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


	
//	@GetMapping("insert") //장바구니 담기 (주문하기 눌렀을 때) -메뉴 여러개 한번에 담기 테스트중
//	public String insert(CartVOList list) {
//		//String id=authentication.getName();
//		
//		//String id=(String)session.getAttribute("id");
//		//log.info("아이디 왜 없어"+id);
////		if(id!=null) {
//			
//			cartService.ShoppingCart(list);
//			return "redirect:/cart/myCart";
//			
////		}else {
////			return "redirect:/login";
////		}	
//	}
	

	
	
}