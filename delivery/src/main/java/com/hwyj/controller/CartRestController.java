package com.hwyj.controller;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwyj.domain.CartVO;
import com.hwyj.service.CartService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/cart/")
@AllArgsConstructor
public class CartRestController {
	
	private CartService cartService;
	
	//장바구니페이지 (목록)
	@GetMapping(value="/cartList", produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<CartVO>> getCartList(Authentication authentication){
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		List<CartVO> cartList = cartService.cartList(userDetails.getUsername());
		List<CartVO> emptyCart = new ArrayList<>();
		int sumTotal=0;
		
		if(cartList.size()!=0) { 
			for(CartVO temp : cartList) {
				sumTotal+=temp.getSum(); //메뉴당 금액 다 더해서 주문 총금액
			}	
			cartList.get(0).setSumTotal(sumTotal);
		}else { 						//메뉴 다 삭제해서 없으면
			CartVO cart = new CartVO();	
			cart.setSumTotal(0);
			emptyCart.add(cart);
		}
				
		return cartList.size()!=0 ? new ResponseEntity<>(cartList, HttpStatus.OK)
								: new ResponseEntity<>(emptyCart, HttpStatus.OK);
	}
	
	//장바구니 메뉴 수량 수정
	@RequestMapping(method= { RequestMethod.PUT, RequestMethod.PATCH }, value="/{cart_no}",
			consumes="application/json", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody CartVO cartVO, @PathVariable("cart_no") int cart_no){
		
		cartVO.setCart_no(cart_no);
		
		return cartService.modifyAmount(cartVO)==true
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
	//장바구니 메뉴 삭제
	@DeleteMapping(value = "/{cart_no}", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("cart_no") int cart_no){
		
		log.info("삭제 메뉴 카트번호: "+cart_no);
		
		return cartService.removeMenu(cart_no)==true
			? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//장바구니 전체삭제
	@DeleteMapping(value="/removeAll", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> removeAll(Authentication authentication){
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String id=userDetails.getUsername(); //로그인한 사용자 아이디
		
		return cartService.removeAll(id)==true
				? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
