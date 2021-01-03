package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;

public interface CartMapper {
	
	//장바구니 넣기
	public int insertCart(CartVO cartVO);
	
//	//장바구니 넣기 (메뉴 여러개)
//	public int insertCart(List<CartVO> cartVOList);
	
	
	
	//장바구니 목록보기
	public List<CartVO> cartList(String id);
	
	//장바구니 수량 수정 (메뉴코드로 찾아서)
	public int updateAmount(String res_menu_code);
	
	//장바구니 메뉴 삭제
	public int removeMenu(String res_menu_code);
	
	//장바구니 전체 삭제
	public int removeCart(String id);
	

}
