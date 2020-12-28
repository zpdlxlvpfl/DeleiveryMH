package com.hwyj.controller;

import java.util.Locale;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/restaurant/*")
@AllArgsConstructor
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	//식당 기본페이지
	@GetMapping("res") //페이지 이름 뭘로하지????
	public void res(String id, Model model) {
		model.addAttribute("menuList", restaurantService.menuList(id));
	}
	
	
	@GetMapping("/reshome") 
	public void reshome() {
		
	}
	
	@GetMapping("/menuwrite") 
	public void menuwrite() {

	}
	
	@GetMapping("/reswrite") 
	public void reswrite() {

	}
	
	@GetMapping("/restList") 
	public void restList() {

	}
	
	
	

	
	@GetMapping("/insertres")  //매장 등록 
	public String insertres (Locale locale, ResVO resvo, Model model) {
		restaurantService.insertres(resvo);
		log.info(resvo);
		System.out.println(resvo);
		return "redirect:/restaurant/reshome";
	}
	 
	@GetMapping("/insertmenu") //메뉴 등록 
	public String insertmenu (ResMenuVO menuvo,RedirectAttributes rttr) {
		restaurantService.insertmenu(menuvo);
		log.info(menuvo);
		System.out.println(menuvo);
		rttr.addFlashAttribute(menuvo);
		return "redirect:/restaurant/reshome";
	}
	

}
