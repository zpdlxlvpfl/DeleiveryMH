package com.hwyj.domain;

import lombok.Data;

@Data
public class EmailVO {
	
	private String senderName; //발신자 이름	
    private String senderMail; //발신자 이메일
    private String receiveMail; //수신자 이메일
    private String subject;
    private String content;            

}
