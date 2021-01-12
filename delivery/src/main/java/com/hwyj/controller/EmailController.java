package com.hwyj.controller;

import  org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
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
	
	
	//아이디 찾기
	@RequestMapping(value="/findId", method= {RequestMethod.POST}, consumes="application/json", produces= "application/json; charset=UTF-8")
	public @ResponseBody String findId(@RequestBody CustomerVO customerVO){
		
		CustomerVO cusVO = memberService.findId(customerVO);	
		String status = null;
		
		if(cusVO!=null) { //해당 회원이 있으면
			EmailVO emailVO = new EmailVO();
			emailVO.setReceiveMail(cusVO.getEmail()); //회원정보에 있는 메일로
			emailVO.setContent(cusVO.getId()); //아이디 보내기
			if(emailService.sendEmail(emailVO, "findId")) {
				status="메일을 발송했습니다. 메일을 확인해주세요"; //메일 발송하면 나오는 메세지
			}else {
				status="메일 발송에 오류가 생겼습니다."; //발송 오류나면 나오는 메세지
			}
				
		}else {
			status="회원정보를 찾을 수 없습니다."; //회원 정보가 없으면 나오는 메세지
		}
		
		String jsonStr = new Gson().toJson(status); //json으로 바꿔서 안보내면 기능은 정상적으로 돌아가는데 error로 잡힘
		log.info("JSON으로????"+jsonStr);
		
		return jsonStr;
	}
			
	//비밀번호 찾기
	@RequestMapping(value="/findPw", method= {RequestMethod.POST}, consumes="application/json", produces= "application/json; charset=UTF-8")
	public @ResponseBody String findPw(@RequestBody CustomerVO customerVO){
		String status = null;
		if(memberService.findPw(customerVO)) { //해당회원이 있다면
			EmailVO emailVO = new EmailVO();
			emailVO.setId(customerVO.getId());
			emailVO.setReceiveMail(customerVO.getEmail()); //수신자 이메일주소
			
			System.out.println("멤버있음!!!");
			
			if(emailService.sendEmail(emailVO, "findPw")) {
				System.out.println("메일발송성공");
				status="메일을 발송했습니다. 메일을 확인해주세요";
			}else {
				System.out.println("메일발송오류!!!");
				status="메일 발송에 오류가 생겼습니다.";
			}
			
		}else {
			System.out.println("없는회원!!!!!!!!!!");
			status="회원정보를 찾을 수 없습니다.";
		}
		
		String jsonStr = new Gson().toJson(status); //json으로 바꿔서 안보내면 기능은 정상적으로 돌아가는데 error로 잡힘
		log.info("JSON으로????"+jsonStr);
		
		return jsonStr;
	}
	
	
//	@RequestMapping(value="/findPw2", method= {RequestMethod.POST}, consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
//	public ResponseEntity<String> findPw(@RequestBody CustomerVO customerVO){
//		String status = null;
//		if(memberService.findPw(customerVO)) { //해당회원이 있다면
//			EmailVO emailVO = new EmailVO();
//			emailVO.setId(customerVO.getId());
//			emailVO.setReceiveMail(customerVO.getEmail()); //수신자 이메일주소
//			
//			System.out.println("멤버있음!!!");
//			
//			if(emailService.sendEmail(emailVO, "findPw")) {
//				System.out.println("메일발송성공");
//				status="SendSuccess";
//			}else {
//				System.out.println("메일발송오류!!!");
//				status="SendFail";
//			}
//			
//		}else {
//			System.out.println("없는회원!!!!!!!!!!");
//			status="NoInformation";
//		}
//
//		return status.equals("SendSuccess") ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	

	

}
