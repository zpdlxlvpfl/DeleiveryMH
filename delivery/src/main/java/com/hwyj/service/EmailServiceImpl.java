package com.hwyj.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

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
			
			msgHelper.setFrom("hantest443370@gmail.com");
			msgHelper.setTo(emailVO.getReceiveMail()); //받는사람
//			msgHelper.setSubject(emailVO.getSubject()); //메일 제목
//			msgHelper.setText(emailVO.getContent()); //메일 내용
			msgHelper.setSubject("고객님의 아이디 입니다."); //메일 제목
			msgHelper.setText("고객님의 아이디는 \n"+emailVO.getContent()+" 입니다."); //메일 내용
			
//			msg.addRecipient(RecipientType.TO, new InternetAddress(emailVO.getReceiveMail()));
//			
//			msg.addFrom(new InternetAddress[] {new InternetAddress("hantest443370", "보내는사람")});
//			
//			msg.setSubject(emailVO.getSubject(), "utf-8");
//			msg.setText(emailVO.getContent(), "utf-8");
			
			jmailSender.send(msg);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}

}
