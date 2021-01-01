package com.hwyj.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.EmailVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {
	
	
	private JavaMailSender jmailSender;
	
	private MemberService memberService;

	@Override
	public boolean sendEmail(EmailVO emailVO, String request) {	
		try {
			MimeMessage msg=jmailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			
			msgHelper.setFrom("testhan70@gmail.com", "OO배달서비스"); //발신메일, 이름
			msgHelper.setTo(emailVO.getReceiveMail()); //수신자 메일주소
			
			if(request.equals("findId")) { //요청된 서비스가 아이디 찾기라면
				msgHelper.setSubject("고객님의 아이디 입니다."); //메일 제목
				msgHelper.setText("고객님의 아이디는 \n"+emailVO.getContent()+" 입니다."); //메일 내용
				
			}else if(request.equals("findPw")) { //요청된 서비스가 비밀번호 찾기라면
				String temporarilyPw="";
				for (int i=0; i<12; ++i) {
					temporarilyPw+=(char)((Math.random()*26)+97); //소문자 랜덤으로 12개 만들기
				}
				PasswordEncoder pwencoder=new BCryptPasswordEncoder();
				CustomerVO customerVO = new CustomerVO();
				customerVO.setId(emailVO.getId());
				customerVO.setPw(pwencoder.encode(temporarilyPw)); 
				
				if(memberService.updatePw(customerVO)) { //임시 비밀번호로 변경이 성공하면
					msgHelper.setSubject("고객님의 임시비밀번호를 발급했습니다."); //메일 제목
					msgHelper.setText("고객님의 임시비밀번호는 \n"+temporarilyPw+
							" 입니다. \n임시비밀번호로 로그인하시고 비밀번호를 변경하여 사용해주세요."); //메일 내용(임시비밀번호)
				}else { //변경 실패하면
					msgHelper.setSubject("임시비밀번호 발급 실패"); //메일 제목
					msgHelper.setText("고객님의 임시비밀번호 발급에 실패했습니다. #####");
				}
					
			}		
			jmailSender.send(msg); //메일 보내기
			return true;
			
		} catch (Exception e) {		
			e.printStackTrace();
			return false;
		} 

	}
	

	

}
