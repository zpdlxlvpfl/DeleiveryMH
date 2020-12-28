package com.hwyj.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hwyj.domain.EmailVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {
	
	
	private JavaMailSender jmailSender;

	@Override
	public void sendEmail(EmailVO emailVO) {	
		try {
			MimeMessage msg=jmailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			
			msgHelper.setFrom("testhan70@gmail.com", "OO배달서비스"); //발신메일, 이름
			msgHelper.setTo(emailVO.getReceiveMail()); //수신자 메일주소
			msgHelper.setSubject("고객님의 아이디 입니다."); //메일 제목
			msgHelper.setText("고객님의 아이디는 \n"+emailVO.getContent()+" 입니다."); //메일 내용
			
			jmailSender.send(msg); //메일 보내기
		} catch (Exception e) {		
			e.printStackTrace();
		} 

	}

}
