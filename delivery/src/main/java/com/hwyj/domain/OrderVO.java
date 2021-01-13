package com.hwyj.domain;
 
import java.sql.Date; 

import lombok.Data;

@Data
public class OrderVO {

	private String	order_no;
	private String	res_code;
	private String	res_menu_code;
	private String	res_menu_price;
	private String	res_menu_acount;
	private String	del_id;
	private String	id;
	private Date    order_date;
	//private int	    order_count;
	
	
	
	private String m_name; //주문자이름
	private String res_menu_name; //메뉴이름
//	private int cart_no; //카트번호
//	private int amount; //수량
//	private int sum; //메뉴당 총금액
//	private int sumTotal; //총 주문금액
//	private int sumAmount; //수량 합칠 때
}
