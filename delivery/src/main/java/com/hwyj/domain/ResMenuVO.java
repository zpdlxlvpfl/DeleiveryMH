package com.hwyj.domain;

import lombok.Data;

@Data
public class ResMenuVO {
	
	private String res_code; //식당코드
	private String res_menu_name; //메뉴이름
	private String red_menu_code; //메뉴번호
	private String res_menu_explan; //메뉴설명
	private int res_menu_price; //가격
	
	private String m_name;//식당 이름
	

}
