package com.hwyj.service;

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

	@Override //장바구니
	public boolean ShoppingCart1(CartVO cartVO) {
		log.info("장바구니담기----------");
		return cartMapper.insertCart1(cartVO)==1;
	}

	@Override //장바구니 (메뉴 한번에 여러개 넣는 서비스)
	public int ShoppingCart(CartVOList cartVOList) {
			
		log.info("장바구니 한번에 여러개 담기----------");	
		List<CartVO> cartList=cartVOList.getCartList();
		
		return cartMapper.insertCart(cartList);
	}

}
