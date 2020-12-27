package com.hwyj.domain;


<<<<<<< HEAD
import java.util.Date;
=======
import java.util.List;
>>>>>>> 5423cbcc703407b9753d4f6a1966559ef9e78101

import lombok.Data;


@Data
public class CustomerVO {

	private	String id;
	private String m_name;
	private String pw;
	private String email;
	private String address;
	private String tel;
<<<<<<< HEAD
	private String enabled;
	//private Date MEMBER_DATE;
	
=======
	private boolean enabled;
	
	private String auth;
	
	private List<AuthVO> authList;//사용자권한 객체 리스트(관리자처럼 여러개의 사용자권한을 가진 계정을 위해서)
>>>>>>> 5423cbcc703407b9753d4f6a1966559ef9e78101
	
	
	
	

}
