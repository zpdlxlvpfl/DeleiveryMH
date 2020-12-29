package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

public interface CartMapper {
	
	//장바구니 넣기
	public int insertCart1(CartVO cartVO);
	
	//장바구니 넣기 (메뉴 여러개)
	public int insertCart(List<CartVO> cartVOList);
	
	//장바구니
	
	

}
