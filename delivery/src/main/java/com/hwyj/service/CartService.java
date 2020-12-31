package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

public interface CartService {
	
	//장바구니 넣기
	public boolean ShoppingCart1(CartVO cartVO);
	
	//장바구니 넣기(한번에 메뉴 여러개) - 메뉴 종류 몇개 담았는지 리턴??? <-이거 필요없을 것 같으면 나중에 void로 변경
	public int ShoppingCart(CartVOList cartVOList);
	
	//장바구니 여러개 넣는거 테스트222
	public int CartTest2(List<CartVO> list);

}
