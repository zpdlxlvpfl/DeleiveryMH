package com.hwyj.service;

import org.springframework.stereotype.Service;

import com.hwyj.domain.CartVO;
import com.hwyj.mapper.CartMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	
	private CartMapper cartMapper;

	@Override
	public boolean ShoppingCart(CartVO cartVO) {
		log.info("장바구니담기----------");
		return cartMapper.insertCart(cartVO)==1;
	}

}
