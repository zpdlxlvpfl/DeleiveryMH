package com.hwyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwyj.domain.EmailVO;
import com.hwyj.service.EmailService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/email/*")
@AllArgsConstructor
public class EmailController {
	
	private EmailService emailService;
	
	@GetMapping("test")
	public void test() {
		
	}
	
	@PostMapping("test")
	public String test(EmailVO emailVO, Model model) {
		
		emailService.sendEmail(emailVO);
		model.addAttribute("message", "이메일이 발송되었습니다.");
		
		return "/index";
	}

}
