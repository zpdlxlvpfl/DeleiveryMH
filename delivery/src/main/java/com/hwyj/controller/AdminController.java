package com.hwyj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CustomerVO;
import com.hwyj.service.AdminService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')") //관리자만 들어올 수 있는 페이지
public class AdminController {
	
	private AdminService adminService;
		
	@GetMapping("/memberList") //멤버 리스트 보는 페이지
	public void memberList(String auth, Model model) {
		//#memberList 열때 기본을 멤버로 열고 매장,관리자는 나중에 따로 선택해서 여는걸로 만들기
		model.addAttribute("memberList", adminService.getMemberList(auth));
		model.addAttribute("auth", auth);
	}
	
	//멤버정보 상세보기 페이지
	@GetMapping("/memberInfo") 
	public void memberInfo(String id, Model model) {
		model.addAttribute("memberInfo", adminService.getMemberInfo(id));
	}
	
	//멤버 삭제
	@PostMapping("/deleteMember")
	public String memberRemove(String id, RedirectAttributes rttr) {
		CustomerVO customerVO=adminService.getMemberInfo(id);
		String url=customerVO.getAuth(); //삭제하는 멤버의 권한을 알아내고
		if(adminService.deleteMember(id)) { //멤버 삭제가 성공하면 
			rttr.addFlashAttribute("result", "success");
		}		
		return "redirect:/admin/memberList?auth="+url; //삭제되는 멤버의 권한이 들어간 멤버리스트 가기
	}
	
	//멤버 아이디 검색
	@GetMapping("search")
	public String searchResults(String keyword, Model model) {
		
		model.addAttribute("search", adminService.search(keyword));
		
		return "/admin/searchResults"; //검색 결과 페이지
	}

}
