package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

public interface CartService {
	
	//장바구니 넣기
	public boolean ShoppingCart(CartVO cartVO);
	
//	//장바구니 넣기(한번에 메뉴 여러개) - 메뉴 종류 몇개 담았는지 리턴??? <-이거 필요없을 것 같으면 나중에 void로 변경
//	public int ShoppingCart(CartVOList cartVOList);
	
	
	
	//장바구니 보기
	public List<CartVO> cartList(String id);
	
	//장바구니 메뉴 수량 수정(cart_no으로 찾고 amount값 넣기)
	public boolean modifyAmount(CartVO cartVO);
	
	//장바구니 메뉴 삭제
	public boolean removeMenu(int cart_no);
	
	//장바구니 전체 삭제
	public boolean removeAll(String id);

}
