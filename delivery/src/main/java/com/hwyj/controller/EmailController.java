package com.hwyj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.EmailVO;
import com.hwyj.service.EmailService;
import com.hwyj.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/email/")
@AllArgsConstructor
public class EmailController {
	
	private EmailService emailService;
	
	private MemberService memberService;
	
	@GetMapping("test")
	public void test() {
		
	}
	
//	@PostMapping("test")
//	public String test(EmailVO emailVO, Model model) {
//		
//		emailService.sendEmail(emailVO);
//		model.addAttribute("message", "이메일이 발송되었습니다.");
//		
//		return "/index";
//	}
	
	
	@RequestMapping(value="/findPw2", method= {RequestMethod.POST}, consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> aaa(@RequestBody CustomerVO customerVO){
		boolean a=false;
		if(memberService.findPw(customerVO)) { //해당회원이 있다면
			EmailVO emailVO = new EmailVO();
			emailVO.setId(customerVO.getId());
			emailVO.setReceiveMail(customerVO.getEmail()); //수신자 이메일주소
			
			System.out.println("멤버있음!!!");
			
			if(emailService.sendEmail(emailVO, "findPw")) {
				System.out.println("메일발송성공");
			}else {
				System.out.println("메일발송오류!!!");
			}
			
			a=true;
		}else {
			System.out.println("없는회원!!!!!!!!!!");
		}
		
		return a==true ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

}
