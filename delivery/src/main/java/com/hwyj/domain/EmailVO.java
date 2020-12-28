package com.hwyj.domain;

import lombok.Data;

@Data
public class EmailVO {
	
	private String senderName; //발신자 이름	
    private String senderMail; //발신메일
    private String receiveMail; //수신메일
    private String subject; //제목
    private String content; //내용          

}
