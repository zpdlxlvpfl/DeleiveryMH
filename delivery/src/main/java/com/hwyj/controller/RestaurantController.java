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
@RequestMapping(value="/restaurant/*")
@AllArgsConstructor
public class RestaurantController {
	
	@Setter(onMethod_ = @Autowired)
	private RestaurantService restaurantService;
	
	@Setter(onMethod_ = @Autowired) //매장 등록 
	private RestaurantMapper restmapper;
	
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
	public void insertres (Locale locale, ResVO resvo, Model model) {
		restmapper.insertres(resvo);
		log.info(resvo);
		System.out.println(resvo);
	}
	 
	@GetMapping("/insertmenu") //메뉴 등록 
	public void insertmenu (ResMenuVO menuvo, Model model) {
		restmapper.insertmenu(menuvo);
		log.info(menuvo);
		System.out.println(menuvo);
	}
	

}
