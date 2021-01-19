package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

public interface CartMapper {
	
	//장바구니 담기
	public int insertCart(CartVO cartVO);
	
	//장바구니 담을 때 이미 장바구니에 있는 메뉴의 가게와 같은 가게인지 확인
	public String compare(String res_menu_code);
	
	//넣었던 메뉴와 똑같은 메뉴를 담으려고 할 때 수량 합쳐주기
	public int sumAmount(CartVO cartVO);
		
	//장바구니 목록보기
	public List<CartVO> cartList(String id);
	
	//장바구니 메뉴 수량 수정(cart_no으로 찾고 amount값 넣기)
	public int updateAmount(CartVO cartVO);
	
	//장바구니 메뉴 삭제
	public int deleteMenu(int cart_no);
	
	//장바구니 전체 삭제
	public int deleteAll(String id);
	

}
