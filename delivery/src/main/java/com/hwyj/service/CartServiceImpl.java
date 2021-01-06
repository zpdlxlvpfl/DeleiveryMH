package com.hwyj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;
import com.hwyj.mapper.CartMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	
	private CartMapper cartMapper;

	@Override //장바구니 담기 서비스
	public boolean ShoppingCart(CartVO cartVO) {
		log.info("장바구니담기----------");
		return cartMapper.insertCart(cartVO)==1;
	}

	@Override //장바구니 보기 서비스
	public List<CartVO> cartList(String id) {
		log.info("장바구니 보기: "+cartMapper.cartList(id));
		return cartMapper.cartList(id);
	}

	@Override //장바구니 메뉴 수량 수정 서비스
	public boolean modifyAmount(CartVO cartVO) {
		
		return cartMapper.updateAmount(cartVO)==1;
	}

	@Override //장바구니 메뉴 삭제 서비스
	public boolean removeMenu(int cart_no) {
		
		return cartMapper.deleteMenu(cart_no)==1;
	}

	@Override //장바구니 전체삭제 서비스
	public boolean removeAll(String id) {
		
		return cartMapper.deleteAll(id)>=1; //삭제된게 1개 이상이면 true
	}

//	@Override //장바구니 (메뉴 한번에 여러개 넣는 서비스)
//	public int ShoppingCart(CartVOList cartVOList) {
//			
//		log.info("장바구니 한번에 여러개 담기----------");	
//		List<CartVO> cartList=cartVOList.getList();
//		
//		return cartMapper.insertCart(cartList);
//	}
	
	
	

}
