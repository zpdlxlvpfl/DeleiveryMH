package com.hwyj.domain;

import lombok.Data;

@Data
public class ResMenuVO {
	
	private String id; //식당id
	private String menu_no; //메뉴번호
	private String menu_name; //메뉴이름
	private String menu_info; //메뉴정보
	private int quantity; //수량
	private int price; //가격
	
	private String m_name;//식당 이름
	

}
