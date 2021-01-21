package com.hwyj.domain;


import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class CustomerVO {

	private	String id;
	private	String res_code;
	private String m_name;
	private String pw;
	private String email;
	private String address;
	private String tel;
	private Date member_date;
	
	private boolean enabled;
	
	private String auth;
	
	private List<AuthVO> authList;//사용자권한 객체 리스트(관리자처럼 여러개의 사용자권한을 가진 계정을 위해서)
	
	
	
	

}
