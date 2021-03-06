package com.hwyj.domain;

import java.util.List;

import lombok.Data;

@Data
public class CartVO {
	
	private int cart_no; //카트번호
	private String id; //주문자 아이디
	private String m_name; //주문자이름
	private String res_menu_code; //메뉴코드
	private String res_menu_name; //메뉴이름
	private int amount; //수량
	private int res_menu_price;
	private int sum; //메뉴당 총금액
	private int sumTotal; //총 주문금액
	private String Payment;
	
	private String res_code; //매장코드
	private int sumAmount; //수량 합칠 때
	
	//private List<CartVO> list;
	

}
