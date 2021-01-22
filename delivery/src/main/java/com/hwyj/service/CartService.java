package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;
import com.hwyj.domain.OrderVO;

public interface CartService {
	
	//장바구니 담기(이미 다른 매장의 메뉴가 담겨있을 경우에는 담지 못한다 + 동일한 메뉴코드를 담으려고 하면 수량을 합쳐준다)
	public boolean ShoppingCart(CartVO cartVO);
	
	//장바구니 보기
	public List<CartVO> cartList(String id);
	
	//장바구니 메뉴 수량 수정(cart_no으로 찾고 amount값 넣기)
	public boolean modifyAmount(CartVO cartVO);
	
	//장바구니 메뉴 삭제
	public boolean removeMenu(int cart_no);
	
	//장바구니 전체 삭제
	public boolean removeAll(String id);
	
	public List<String> getList(String id);
	
	public boolean updateOrder(CartVO cartVO);


}
