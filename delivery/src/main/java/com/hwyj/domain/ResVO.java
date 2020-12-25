package com.hwyj.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ResVO {
	
	private String RES_CODE;
	private String RES_INFO;
	private String ADDRESS;
	private String TEL;
	private String RES_MENU_EXPLAN;
	private Date RES_DATE;
	//private String RES_MENU_NAME;
	//private int RES_MENU_PRICE;
}
