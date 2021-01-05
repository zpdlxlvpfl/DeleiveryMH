package com.hwyj.domain;

import java.util.Date;

import lombok.Data;
@Data
public class OrderVO {
	
	private String order_no ;
	private String gres_code;
	private String res_menu_id;
	private String res_manu_price;
	private String res_manu_acount;
	private String del_id;
	private String id;
	private Date order_date;
	private String order_count;


}
