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
	private int	    order_count;
}
