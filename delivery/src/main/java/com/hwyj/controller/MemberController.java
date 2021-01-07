package com.hwyj.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CustomerVO;
import com.hwyj.security.CustomUserDetailsService;
import com.hwyj.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberService;
	
	@Inject
	
	
	//마이페이지
	@GetMapping("myPage")
	public void myPage() {
		
	}
	
	//내정보보기
	@GetMapping("myInfo") 
	public void myInfo(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); //현재 로그인한 유저 정보
		model.addAttribute("myInfo", memberService.getMyInfo(userDetails.getUsername()));				
	}
	
	//내정보 수정페이지
	@GetMapping("modifyMyInfo")
	public void modifyMyInfo(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		model.addAttribute("myInfo", memberService.getMyInfo(userDetails.getUsername()));
	}
		
	//내정보 수정하면 다시 내정보보기 페이지로
	@PostMapping("modifyMyInfo")
	public String modifyMyInfo(CustomerVO customerVO, RedirectAttributes rttr) {
		
		if(memberService.modifyMyInfo(customerVO)) {
			rttr.addFlashAttribute("result", "m_success");
		}	
		return "redirect:/member/myInfo";
	}
	
	//비밀번호 변경 페이지
	@GetMapping("changePw")
	public void changePw() {
		
	}
	@PostMapping("changePw")
	public String changePw(Authentication authentication, CustomerVO customerVO, String newPw, RedirectAttributes rttr) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); //현재 로그인한 유저 정보
		
		customerVO.setId(userDetails.getUsername()); //아이디
		//customerVO.getPw(); //기존 비밀번호
		//CustomerVO customerVO = new CustomerVO();		
		//customerVO.setPw(pw);
		if(memberService.checkPw(customerVO)) { //입력한 비밀번호가 맞으면
			customerVO.setPw(newPw); //새로 입력한 비밀번호로 셋팅
			if(memberService.updatePw(customerVO)) { //비밀번호 변경 성공하면 성공 메세제 띄우기
				rttr.addFlashAttribute("result", "비밀번호가 변경되었습니다.");
			}else {
				rttr.addFlashAttribute("result", "비밀번호 변경 실패");
			}		
		}else { //틀리면 실패 메세지 띄우기
			rttr.addFlashAttribute("result", "현재 비밀번호가 맞지 않습니다. 다시 확인해주세요. ");
		}
		
		return "redirect:/member/changePw";
	}
	

//	@PostMapping("changePw")
//	public String changePw(Authentication authentication, CustomerVO customeVO, RedirectAttributes rttr) {
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		CustomerVO customerVO = new CustomerVO();
//		customerVO.setId(userDetails.getUsername());
//		if(memberService.updatePw(customerVO)) {
//			rttr.addFlashAttribute("result", "change_success");
//		}else {
//			
//		}
//		return "changePw";
//	}
	

}
