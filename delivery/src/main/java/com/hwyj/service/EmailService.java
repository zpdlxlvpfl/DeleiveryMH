package com.hwyj.service;

import com.hwyj.domain.EmailVO;

public interface EmailService {
	
	//이메일로 아이디 or 비밀번호 찾기
	public boolean sendEmail(EmailVO emailVO, String request);


}
